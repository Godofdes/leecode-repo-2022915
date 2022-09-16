package com.leetcode.forlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    //剑指 Offer II 007. 数组中和为 0 的三个数
    //16:30-17:11,37/318
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0,j=0;i<nums.length;i++){
            if(i==0){
                list.add(j,nums[0]);
                j++;
            }
            else if(nums[i]!=nums[i-1]){
                list.add(j,nums[i]);
                j++;
            }
        }
        int len = list.size();
        for(int i=0;i<len-2;i++){
            int left = i+1;
            int target = 0-nums[i];
            while(left<=(target/2)){
                int right=len-1;
                while (right>=(target/2)){
                    if(right!=left&&left<right&&(list.get(left)+list.get(right))==target){
                        List<Integer> tmplist = new ArrayList<>();
                        tmplist.add(list.get(i));
                        tmplist.add(list.get(left));
                        tmplist.add(list.get(right));
                        resList.add(tmplist);
                    }
                    right--;
                }
                left++;
            }
        }
        return resList;
    }

    //考虑错误的点，消除重复元素，事实上重复元素是不能消除的，题目只是要求下标不同
    //排序没问题，
//    首先排序，固定一个数，然后双指针。
//    有两个地方需要去重。
//    首先外层循环选择那个固定的数字时，如果出现当前数字和前一个数字相等的情况，需要跳过。
//    然后就是移动双指针时，左指针需要跳过其右侧所有相等的数，右指针也需要跳过其左侧所有相等的数。

    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>resList = new ArrayList<>();
        int len = nums.length;

        for(int i=0;i<len-2;i++){
            if(i!=0&&nums[i]==nums[i-1])    continue;

            int left = i+1,right=len-1;
            int target = 0-nums[i];
            while(left<right){
                if(nums[left]+nums[right]==target){
                    resList.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    int tmp = nums[left];
                    while (left<right&&nums[left]==tmp) left++;
                    tmp = nums[right];
                    while (left<right&&nums[right]==tmp) right--;

                }
                else if(nums[left]+nums[right]>target){
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return resList;
    }

    //剑指 Offer II 008. 和大于等于 target 的最短子数组
    //22:55-23:13-23:27
    public int minSubArrayLen(int target, int[] nums) {

        int len = nums.length;
        if(len==1){
            if(nums[0]>=target) return 1;
            else return 0;
        }
        int l = 0,r=1,sum=0,min=len;
        while (l<r&&r<len){
            while (l<r&&sum<target){
                sum+=nums[r];
                r++;
            }if(r-l==len){
                return 0;
            }
            min = Math.min(min,r-l);
            while (l<r&&sum>target){
                sum-=nums[l];
                l++;
            }
        }
        return min;
    }
    //剑指 Offer II 009. 乘积小于 K 的子数组
    //23:28-0:02
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;

        int l=0,r=0,sum = 1,count=0;
        while (r<len){
            sum*=nums[r];
            r++;
            if(sum<k){
                count+=r-l;
            }
            else {
                while (l<r&&sum>=k){
                    sum/=nums[l];
                    l++;
                }
                count+=r-l;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        System.out.println(numSubarrayProductLessThanK(num,13));;
    }

}
