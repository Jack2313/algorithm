package com.ljiangf.JavaIO;

import java.util.Scanner;

public class JavaIO {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        System.out.println(a);

        // next方式接收字符串
        System.out.println("next方式接收字符串");
        // 判断是否还有输入
        if (s.hasNext()) {
            String str1 = s.next();
            System.out.println(str1);
        }

        // next方式接收字符串
        System.out.println("接收int");
        // 判断是否还有输入
        int i = s.nextInt();
        System.out.println(i);

        System.out.println("next方式接收int");
        if (s.hasNext()) {
            int int1 = s.nextInt();
            System.out.println(int1);
        }
        s.close();
    }
}
