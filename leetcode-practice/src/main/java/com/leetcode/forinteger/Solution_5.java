package com.leetcode.forinteger;

import java.util.Random;

//剑指 Offer II 006. 排序数组中两个数字之和
//17:28-17:54
public class Solution_5 {

    public static void main(String[] args) {
        int[] acc = {-1,0};
        int[] ac = twoSum(acc,-1);
        System.out.println(ac[0]+" "+ac[1]);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int flag = target/2;
        int len = numbers.length;

        boolean ac = false;
        for (int left=0;(numbers[left]<=len);left++){
            int right=len-1;
            while (numbers[right]>=len){
                if((numbers[right]+numbers[left]==target)&&left!=right){

                    int[] acc = new int[2];
                    acc[0] = left;
                    acc[1] = right;
                    return acc;
                }
                else right--;
            }
        }
        return null;
    }


}
