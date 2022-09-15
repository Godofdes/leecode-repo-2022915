package com.leetcode.forinteger;

//剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
public class Solution_2 {

    public int[] countBits(int n) {
        int[] nums =  new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0||i==1){
                nums[i] = i;
            }
            if(i%2==0){
                nums[i]=nums[i>>1];
            }
            else {
                nums[i]=nums[i>>1]+1;
            }

        }
        return nums;
    }
}
