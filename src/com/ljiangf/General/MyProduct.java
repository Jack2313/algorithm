package com.ljiangf.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyProduct {

    public static List<List<Integer>> calculateProduct(List<List<Integer>> nums){
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null){
            return ans;
        }
        // 过滤为空或为null的
        nums = nums.stream().filter(list -> list!=null && !list.isEmpty()).collect(Collectors.toList());
        if(nums.size()==0){
            return ans;
        }

        // 基于nums.get(0)初始化
        for(int i=0;i<nums.get(0).size();i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums.get(0).get(i));
            ans.add(temp);
        }
        for(int i=1;i<nums.size();i++){
            ans = recursiveFunc(ans, nums.get(i));
        }
        return ans;
    }

    private static List<List<Integer>> recursiveFunc(List<List<Integer>> tempResult, List<Integer> newArray){
        List<List<Integer>> ans = new ArrayList<>();
        tempResult.forEach(singleArray -> {
            // 每次用tempResult中的一个数组加上newArray中的每一个元素
            newArray.forEach(integer -> {
                List<Integer> result = new ArrayList<>(singleArray);
                result.add(integer);
                ans.add(result);
            });
        });

        return ans;
    }

    public static void main(String[] args){
        List<List<Integer>> testNullArray = null;
        System.out.println("testNullArray:\t"+calculateProduct(testNullArray));

        List<List<Integer>> testEmptyArray = new ArrayList<>();
        System.out.println("testEmptyArray:\t"+calculateProduct(testEmptyArray));

        List<List<Integer>> testNullSubArray = new ArrayList<>();
        testNullSubArray.add(null);
        System.out.println("testNullSubArray:\t"+calculateProduct(testNullSubArray));

        List<List<Integer>> testEmptySubArray = new ArrayList<>();
        testEmptySubArray.add(new ArrayList<>());
        System.out.println("testEmptySubArray:\t"+calculateProduct(testEmptySubArray));

        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(2, 5));
        test1.add(Arrays.asList(1));
        test1.add(Arrays.asList(7, 6, 4));
        System.out.println("test1:\t"+calculateProduct(test1));

        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(Arrays.asList(2, 5));
        test2.add(Arrays.asList(1, 8));
        test2.add(Arrays.asList(7, 6, 4));
        test2.add(new ArrayList<>());
        System.out.println("test2:\t"+calculateProduct(test2));
    }
}
