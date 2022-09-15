package com.leetcode.forinteger;

//剑指 Offer II 005. 单词长度的最大乘积
public class Solution_4 {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            int tmp = 0;
            for(int j=0;j<words[i].length();j++){
                int acnum = words[i].charAt(j)-'a';
                if(((tmp>>acnum)&1)==0){
                    tmp+=1<<(words[i].charAt(j)-'a');
                }
            }
            nums[i] = tmp;
        }
        int max = 0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int tmp = nums[i]&nums[j];
                if(tmp==0){
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
