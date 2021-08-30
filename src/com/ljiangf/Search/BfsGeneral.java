package com.ljiangf.Search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//ladderLength
//https://leetcode-cn.com/problems/word-ladder/
//给定两个单词（beginWord 和 endWord）和一个字典，找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
//每次转换只能改变一个字母。转换过程中的中间单词必须是字典中的单词。
//tested correct on Leetcode

//ladderLengthDoubleBFS
//https://leetcode-cn.com/problems/word-ladder/
//使用双向BFS解决问题
//tested correct on Leetcode
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
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            visited[idx] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++count;
            while (size-- > 0) {
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); ++i) {
                    // 通过 index 判断是否已经访问
                    if (visited[i]) {
                        continue;
                    }
                    String s = wordList.get(i);
                    if (!canChange(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    visited[i] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public int ladderLengthDoubleBFS(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1; //
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        boolean[] visited1 = new boolean[wordList.size()];
        boolean[] visited2 = new boolean[wordList.size()];
        queue1.offer(start);
        queue2.offer(end);
        visited1[start]=true;
        visited2[end]=true;
        int level = 0;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            level++;
            if (queue1.size() > queue2.size()) {
                Queue<Integer> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                boolean[] t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = wordList.get(queue1.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited1[i]) {
                        continue;
                    }
                    if (!canChange(s, wordList.get(i))) {
                        continue;
                    }
                    if (visited2[i]) {
                        return level + 1;
                    }
                    visited1[i] = true;
                    queue1.offer(i);
                }
            }
        }
        return 0;
    }
}
