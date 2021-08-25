package com.ljiangf.String;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class sortString {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.nextLine();
        List<String> strings = new ArrayList<>();
        for(int i=0;i<num;i++){
            strings.add(s.nextLine());
        }
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int minLen = Math.min(o1.length(), o2.length());
                int i=0;
                while(i<minLen){
                    if(o1.charAt(i)!=o2.charAt(i)){
                        return o1.charAt(i)-o2.charAt(i);
                    }
                    i++;
                }

                return o1.length()-o2.length();
            }
        });

        for(String str : strings){
            System.out.println(str);
        }
    }
}
