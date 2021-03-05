package com.ljiangf.Search;

import java.util.*;
//combinationSum
//https://leetcode-cn.com/problems/combination-sum/
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//tested correct on Leetcode

//combinationSum2
//https://leetcode-cn.com/problems/combination-sum-ii/
//给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
//candidates中的每个数字在每个组合中只能使用一次。
//tested correct on Leetcode

//permute
//https://leetcode-cn.com/problems/permutations/
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//tested correct on Leetcode
public class BackTrack {
    private List<List<Integer>> combinationSum(int[] candidates, int target, int p) {
        List<List<Integer>> ans = new LinkedList<>();
        for(int i=p;i<candidates.length;i++){
            if(candidates[i]>target){
                continue;
            }else if(candidates[i]==target){
                List<Integer> origin = new LinkedList<>();
                origin.add(candidates[i]);
                ans.add(origin);
            }else{
                List<List<Integer>> temp = combinationSum(candidates, target-candidates[i], i);
                for(List<Integer> y: temp){
                    y.add(candidates[i]);
                }
                ans.addAll(temp);
            }
        }
        return ans;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if(candidates.length==0)return ans;
        return combinationSum(candidates, target, 0);
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target, int p) {
        List<List<Integer>> ans = new LinkedList<>();
        if(target==0){
            List<Integer> origin = new LinkedList<>();
            ans.add(origin);
            return ans;
        }
        for(int i=p;i<candidates.length;i++){
            if(candidates[i]>target){
                continue;
            }else if(candidates[i]==target){
                List<Integer> origin = new LinkedList<>();
                origin.add(candidates[i]);
                ans.add(origin);
                break;
            }else{
                int tempp=i+1;
                while(tempp<candidates.length && candidates[tempp]==candidates[i]){
                    ++tempp;
                }

                for(int j=1;j<=tempp-i;j++){
                    List<List<Integer>> temp = combinationSum2(candidates, target-candidates[i]*j, tempp);
                    for(List<Integer> y: temp){
                        for(int z=0;z<j;++z){
                            y.add(candidates[i]);
                        }
                    }
                    ans.addAll(temp);
                }
                i=tempp-1;

            }
        }
        return ans;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if(candidates.length==0)return ans;
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0);
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
}
