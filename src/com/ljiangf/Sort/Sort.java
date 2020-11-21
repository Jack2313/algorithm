package com.ljiangf.Sort;

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

    private static void adjustHeap(int[] array,int i,int length){
        int temp = array[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && array[k]<array[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(array[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                array[i] = array[k];
                i = k;
            }else{
                break;
            }
        }
        array[i] = temp;//将temp值放到最终的位置
    }

    public static void heapSort(int[] array){
        for(int i=array.length/2-1;i>=0;--i){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(array,i,array.length);
        }

        for(int j=array.length-1;j>=0;--j){
            GeneralMethods.swap(array, 0, j);
            adjustHeap(array,0,j);
        }
    }

    public static void main(String[] args){
        for(int i=0;i<100;i++){
            int[] a=GeneralMethods.gennerateArray(100,1000);
            //bubbleSort(a, 0, a.length-1);
            //insertSort(a, 0, a.length-1);
            //mergeSort(a, 0, a.length-1);
            //quickSort(a, 0, a.length-1);
            heapSort(a);
            System.out.println(Arrays.toString(a));
        }
    }
}
