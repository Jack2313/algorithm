package com.ljiangf.String;

import java.util.*;

public class reduceString {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            Map<Character, Integer> map = new HashMap<>();
            String str = s.nextLine();
            for(int i=0;i<str.length();i++){
                if(!map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i), 1);
                }else{
                    map.put(str.charAt(i), map.get(str.charAt(i))+1);
                }
            }

            int min = 0x7fffffff;
            List<Character> minChars = new ArrayList<>();
            for(Map.Entry<Character, Integer> entry:map.entrySet()){
                if(entry.getValue() == min){
                    minChars.add(entry.getKey());
                    continue;
                }
                if(entry.getValue() < min){
                    minChars = new ArrayList<>();
                    minChars.add(entry.getKey());
                    min = entry.getValue();
                }
            }

            for(Character c:minChars){
                str = str.replaceAll(c.toString(), "");
            }
            System.out.println(str);
        }
    }
}
