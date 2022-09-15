package com.leetcode.forinteger;


//剑指 Offer II 002. 二进制加法
public class Solution_1 {
    //20min try
    public String addBinary1(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int len = len1>len2?len1:len2;
        char[] res = {};

        for(int i=0;i<len;i++){

        }

        return "";
    }
    //res 1 模拟
    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = Math.max(a.length(),b.length()),carry=0;

        for(int i = 0; i<n;++i){
            carry +=i<a.length()?(a.charAt(a.length()-i-1)-'0'):0;
            carry +=i<b.length()?(b.charAt(b.length()-i-1)-'0'):0;
            ans.append(carry%2==0?'0':'1');

            carry/=2;

        }
        if(carry>0){
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();

    }
    //位运算
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<32;++i){
            int total = 0;
            for(int num:nums){
                total+=((num>>i)&1);

            }
            if(total%3!=0){
                ans|=(1<<i);
            }
        }
        return ans;
    }
    public String addBinary3(String a, String b) {
        return "";
    }
}
