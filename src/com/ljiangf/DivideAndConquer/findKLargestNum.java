package com.ljiangf.DivideAndConquer;

import java.util.Arrays;
import com.ljiangf.General.GeneralMethods;
//test correct on Leetcode
//https://leetcode-cn.com/problems/kth-largest-element-in-an-array
public class findKLargestNum {
    //最简单的方法是排序后取第k个
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left; //永远指向左侧第一个大数
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                GeneralMethods.swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        GeneralMethods.swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    //结合快速排序，每次返回索引，如果索引比较k偏小了，那么在右侧找，反之在左侧找
    public int findKthLargestQS(int[] nums, int k){
        int target = nums.length - k;
        int left = 0;
        int right = nums.length;
        int index = partition(nums, left, right);
        while(index!=target){
            if(index>target){
                index = partition(nums, left, index-1);
            }else{
                index = partition(nums, index+1, right);
            }
        }
        return nums[target];
    }

}
