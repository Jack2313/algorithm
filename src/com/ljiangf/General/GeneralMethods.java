package com.ljiangf.General;

import javafx.util.Pair;

public class GeneralMethods {
    public static void swap(int[] array, int k1, int k2){
        int temp = array[k1];
        array[k1] = array[k2];
        array[k2] = temp;
    }

    public static Pair<Integer, Integer> argmax(int[] array, int left, int right){
        int max = 0x80000000;
        int maxp = -1;
        for (int i=left; i<right; ++i) {
            if(array[i]>max){
                max = array[i];
                maxp = i;
            }
        }
        return new Pair<Integer, Integer>(maxp, max);
    }

    public static Pair<Integer, Integer> argmin(int[] array, int left, int right){
        int min = 0x7fffffff;
        int minp = -1;
        for (int i=left; i<right; ++i) {
            if(array[i]<min){
                min = array[i];
                minp = i;
            }
        }
        return new Pair<Integer, Integer>(minp, min);
    }

    public static int[] gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }
}
