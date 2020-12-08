package com.ljiangf.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//canBreak
//https://leetcode-cn.com/problems/word-break/
//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//tested correct on Leetcode

//wordBreak
//https://leetcode-cn.com/problems/word-break-ii/
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//tested correct on Leetcode
public class WordBreak {
    public boolean canBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean[] canSubBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp;
    }

    private List<List<String>> subBreak(String s, List<String> wordDict, boolean[] dp){
        int len = s.length();
        List<List<String>> ans = new ArrayList<>();
        if(wordDict.contains(s)){
            List<String> thisStr = new ArrayList<>();
            thisStr.add(s);
            ans.add(thisStr);
        }

        for(int i=0;i<len;++i){
            if(!dp[i]) continue;
            if(wordDict.contains(s.substring(i)) && dp[i]){
                List<List<String>> temp = subBreak(s.substring(0,i), wordDict, dp);
                for(List<String> x: temp){
                    x.add(s.substring(i));
                }
                ans.addAll(temp);
            }
        }
        return ans;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        boolean[] dp = canSubBreak(s, wordDict);
        if(!dp[s.length()]) return result;
        List<List<String>> temp = subBreak(s, wordDict, dp);
        for (List<String> wordBreak : temp) {
            result.add(String.join(" ", wordBreak));
        }
        return result;
    }
}
