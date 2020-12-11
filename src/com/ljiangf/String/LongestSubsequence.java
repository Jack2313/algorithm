package com.ljiangf.String;

//longestCommonSubsequence
//https://leetcode-cn.com/problems/longest-common-subsequence/
//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
//一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//tested correct on Leetcode

//longestPalindromeSubseq
//https://leetcode-cn.com/problems/longest-palindromic-subsequence/
//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。
//
public class LongestSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }

        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        return dp[n][m];
    }

    public int longestPalindromeSubseq(String s) {
        if(s.equals(""))return 0;
        int head = 0;
        int tail = s.length()-1;
        if(tail==0)return 1;
        int ans = 0;
        if(s.charAt(head)==s.charAt(tail)){
            ans = 2 + longestPalindromeSubseq(s.substring(head+1, tail));
        }else{
            ans = Math.max(
                    longestPalindromeSubseq(s.substring(head, tail)),
                    longestPalindromeSubseq(s.substring(head+1))
            );
        }
        return ans;
    }
}
