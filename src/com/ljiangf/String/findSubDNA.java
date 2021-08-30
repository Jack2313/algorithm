package com.ljiangf.String;

// https://leetcode-cn.com/problems/repeated-dna-sequences/
// 187. 重复的DNA序列
// 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
//
//编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

import java.util.*;

public class findSubDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        int index1 = 0;
        int index2 = 1;
        int len = s.length()-10;
        if(len <= 0){
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        while(index1<len){
            while(index2<len){
                if(s.charAt(index1) == s.charAt(index2)){
                    String temp = s.substring(index1, index1+10);
                    if(result.contains(temp)){
                        break;
                    }
                    boolean isEqual = true;
                    for(int i=1;i<10;i++){
                        if(s.charAt(index1+i) != s.charAt(index2+i)){
                            isEqual = false;
                            break;
                        }
                    }
                    if(isEqual){
                        result.add(temp);
                        break;
                    }
                }
                index2++;
            }

            index1++;
            index2 = index1+1;
        }
        return new ArrayList<>(result);
    }
}
