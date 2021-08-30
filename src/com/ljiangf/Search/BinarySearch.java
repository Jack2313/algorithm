package com.ljiangf.Search;

//BinarySearch
//最基本的二分查找

//searchInsert
//https://leetcode-cn.com/problems/search-insert-position/
//最基本的二分查找，找不到返回插入位置。
//tested correct on Leetcode

//mySqrt
//https://leetcode-cn.com/problems/sqrtx/
//计算并返回 x 的平方根，其中 x 是非负整数。返回只保留整数部分
public class BinarySearch {
    private int BinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) / 2;
        if(right == -1)return 0;
        while(left <= right){
            if(nums[mid] > target){
                right = mid-1;
                mid = (left + right) / 2;
            }else if(nums[mid] < target){
                left = mid+1;
                mid = (left + right) / 2;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) / 2;
        if(right == -1)return 0;
        while(left <= right){
            if(nums[mid] > target){
                right = mid-1;
                mid = (left + right) / 2;
            }else if(nums[mid] < target){
                left = mid+1;
                mid = (left + right) / 2;
            }else{
                return mid;
            }
        }
        if(nums[mid]>target){
            return mid;
        }else{
            return mid+1;
        }
    }

    public int mySqrt(int x) {
        if(x<2)return x;
        int i=1;
        int j=x;
        int ans = -1;

        while(i<=j){
            int mid = (i+j)/2;
            if(mid<=x/mid){
                ans=mid;
                i=mid+1;
            }else{
                j=mid-1;
            }
        }

        return ans;
    }
}
