package com.ljiangf.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaIO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println("Use BufferedReader: "+line);

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
    }
}
