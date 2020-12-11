package com.ljiangf.String;

//isMatchEasy
//https://leetcode-cn.com/problems/wildcard-matching/
//*匹配任意多字符，使用动态规划
//tested correct on Leetcode

//isMatchGreedy
//https://leetcode-cn.com/problems/wildcard-matching/
//*匹配任意多字符，使用贪心算法
//
public class RegularExpressionMatch {
    public boolean isMatchEasy(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        //针对开局一堆*的情况
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //这里不能匹配不成功就break，因为这条路false不代表其他不行。
                //例如aaaaab和*aab，对于dp[0][:-2]都为true，对b为false，但是匹配还要继续
            }
        }
        return dp[m][n];
    }

    public boolean isMatchGreedy(String s, String p) {

    }

    public boolean isMatch(String s, String p) {

    }
}
