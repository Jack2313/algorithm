package com.ljiangf.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> position = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();
        int len = s.length();
        for (int i=0;i<len;++i) {
            position.put(s.charAt(i), i);
        }

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<len;++i){
            char c = s.charAt(i);
            if(seen.contains(c)){
                continue;
            }
            while(!stack.isEmpty() && c < stack.peek() && position.get(stack.peek()) > i){
                seen.remove(stack.pop());
            }
            seen.add(c);
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) sb.append(c.charValue());

        return sb.toString();
    }



}
