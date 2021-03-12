package com.ljiangf.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaIO {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        System.out.println("Use BufferedReader: "+line);
//
        //对于定长数组输入:
        //5
        //1 2 3 4 5
        Scanner s = new Scanner(System.in);
        int a;
        List<Integer> arr = new ArrayList<>();
        a = s.nextInt();
        for(int i=0;i<a;i++){
            arr.add(s.nextInt());
        }
        System.out.println(arr.toString());
        if (s.nextLine().equals("\n")) {
            System.out.println("yes");
        }

        //对于不定长数组
        while(s.hasNextLine()){
            List<Integer> arr1 = new ArrayList<>();
            String arrline = s.nextLine();
            String[] str = arrline.split(" ");
            for(String t: str){
                arr1.add(Integer.parseInt(t));
            }
            System.out.println(arr1.toString());
        }


        //对于定行输入
        //2
        //1 2 3
        //4 5 6 7 8
//        List<List<Integer>> arr2 = new ArrayList<>();
//        int b = s.nextInt();
//        for(int i=0;i<b;i++){
//            List<Integer> temp = new ArrayList<>();
//            while(s.hasNextInt()){
//                temp.add(s.nextInt());
//            }
//            arr2.add(temp);
//        }
//
//        System.out.println(arr2.toString());
    }
}
