package com.ljiangf.DynamicProgramming;

public class MaxRecursiveSubstr {

    private String maxRecursiveSubstr(String s){
        if(s==null||s.length()==0)return s;
        int maxLength = 1;
        int maxStart = 0;
        int maxEnd = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int end=0;end<s.length();end++){
            for(int start=0;start<=end;start++){
                int len = end-start+1;
                if(len==1){
                    dp[start][end]=true;
                }else if(s.charAt(end)==s.charAt(start)){
                    if(len==2){
                        dp[start][end]=true;
                    }else{
                        dp[start][end]=dp[start+1][end-1];
                    }
                }else{
                    // 不相等怎么都不回文
                    dp[start][end] = false;
                }

                if(dp[start][end] && len>maxLength){
                    maxLength = len;
                    maxStart = start;
                    maxEnd = end;
                }

            }

        }
        // 如果要长度则返回maxLength
        return s.substring(maxStart, maxEnd+1);
    }

    public static void main(String[] args){
        String s1 = "abba";
        String s2 = "abbc";
        String s3 = "abcd";
        MaxRecursiveSubstr maxRecursiveSubstr = new MaxRecursiveSubstr();
        System.out.println(maxRecursiveSubstr.maxRecursiveSubstr(s1));
        System.out.println(maxRecursiveSubstr.maxRecursiveSubstr(s2));
        System.out.println(maxRecursiveSubstr.maxRecursiveSubstr(s3));
    }
}
