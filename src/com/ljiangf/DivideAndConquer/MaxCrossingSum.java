package com.ljiangf.DivideAndConquer;
//tested correct on Leetcode
//https://leetcode-cn.com/problems/contiguous-sequence-lcci/
public class MaxCrossingSum {
    public static int maxCrossingSum(int[] array, int left, int right){
        if(left>=right){
            return array[left];
        }
        int mid=(left+right)/2;
        int lmax=maxCrossingSum(array, left, mid);
        int rmax=maxCrossingSum(array, mid+1, right);
        int max=0x80000000;
        int leftSum=0, rightSum=0;
        for(int i = mid; i >= left; i--)
        {
            leftSum += array[i];
            max = Math.max(max,leftSum);
        }
        int rightmax = 0x80000000;
        // 求右边的最大和
        for(int i = mid + 1; i <= right; i++)
        {
            rightSum += array[i];
            rightmax = Math.max(rightmax,rightSum);
        }
        max += rightmax;
        return Math.max(Math.max(lmax, rmax), max);
    }
}
