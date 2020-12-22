package com.ljiangf.Search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//ladderLength
//https://leetcode-cn.com/problems/word-ladder/
//给定两个单词（beginWord 和 endWord）和一个字典，找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
//每次转换只能改变一个字母。转换过程中的中间单词必须是字典中的单词。
public class BfsGeneral {
    private boolean canChange(String beginWord, String endWord){
        int len = beginWord.length();
        boolean different = false;
        for(int i=0;i<len;i++){
            if(beginWord.charAt(i)!=endWord.charAt(i)){
                if(different)return false;
                different = true;
            }
        }
        return different;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        if(beginWord.equals(endWord))return ans;
        if(!wordList.contains(endWord))return ans;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            ans++;
            int a = queue.size();
            for(int i=0;i<a;i++){
                String temp = queue.poll();
                wordList.remove(temp);
                char[] ch = temp.toCharArray();
                for (int j = 0; j < temp.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == temp.charAt(j))
                            continue;
                        ch[j] = c;
                        String sss = String.valueOf(c);
                        System.out.println(sss);
                        if (wordList.contains(sss)) {
                            //System.out.println(temp+" "+s);
                            if (sss.equals(endWord)) {
                                return ans + 1;
                            }
                            queue.add(sss);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
