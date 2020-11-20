package com.ljiangf.Sort;

import com.ljiangf.General.GeneralMethods.*;

import com.ljiangf.General.GeneralMethods;
import javafx.util.Pair;

import java.util.Arrays;

public class Sort {

    public static void bubbleSort(int[] array, int left, int right){
        for (int i=left; i<=right; ++i) {
            for(int j=i+1; j<=right ; ++j){
                if(array[i]>array[j]){
                    GeneralMethods.swap(array, i, j);
                }
            }
        }
    }

    public static void insertSort(int[] array, int left, int right){
        for (int i=left; i<=right; ++i) {
            Pair<Integer, Integer> min = GeneralMethods.argmin(array, i, right);
            GeneralMethods.swap(array, i, min.getKey());
        }
    }

    private static void merge(int[] array, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right){
            if(array[i]<array[j]){
                temp[k++]=array[i++];
            }else{
                temp[k++]=array[j++];
            }
        }
        while(i<=mid){
            temp[k++]=array[i++];
        }
        while(j<=right){
            temp[k++]=array[j++];
        }

        for(int x=0;x<temp.length;x++){
            array[x+left]=temp[x];
        }

    }

    public static void mergeSort(int[] array, int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    public static void quickSort(int[] array, int left, int right){
        if(left<right){
            int v = array[left];
            int i=left;
            int j=right;
            int index = left;
            while(i<j){
                while(array[j]>=v&&i<j){
                    --j;
                }
                while(array[i]<=v&&i<j){
                    ++i;
                }
                if(i<j){
                    GeneralMethods.swap(array, i ,j);
                }
            }
            GeneralMethods.swap(array, i ,index);
            quickSort(array, left, i-1);
            quickSort(array, i+1, right);
        }
    }

    public static void heapSort(int[] array, int left, int right){

    }

    public static void main(String[] args){
        int[] a={5,4,3,1,2};
        //bubbleSort(a, 0, a.length-1);
        //insertSort(a, 0, a.length-1);
        //mergeSort(a, 0, a.length-1);
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
