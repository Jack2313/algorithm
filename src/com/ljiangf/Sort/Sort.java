package com.ljiangf.Sort;

import com.ljiangf.General.GeneralMethods.*;

import com.ljiangf.General.GeneralMethods;
import javafx.util.Pair;

import java.util.Arrays;

public class Sort {

    public static void bubbleSort(int[] array, int left, int right){
        for (int i=left; i<right; ++i) {
            for(int j=i+1; j<right ; ++j){
                if(array[i]>array[j]){
                    GeneralMethods.swap(array, i, j);
                }
            }
        }
    }

    public static void insertSort(int[] array, int left, int right){
        for (int i=left; i<right; ++i) {
            Pair<Integer, Integer> min = GeneralMethods.argmin(array, i, right);
            GeneralMethods.swap(array, i, min.getKey());
        }
    }

    public static void mergeSort(int[] array, int left, int right){

    }

    public static void quickSort(int[] array, int left, int right){

    }

    public static void heapSort(int[] array, int left, int right){

    }

    public static void main(String[] args){
        int[] a={5,4,3,1,2};
        //bubbleSort(a, 0, a.length);
        insertSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }
}
