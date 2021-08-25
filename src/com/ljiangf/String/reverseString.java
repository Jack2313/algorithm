package com.ljiangf.String;

import java.util.Scanner;

public class reverseString {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        System.out.println(stringBuilder.reverse().toString());
    }
}
