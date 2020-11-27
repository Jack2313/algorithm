package com.ljiangf.GreedyAlgorithm;

//https://leetcode-cn.com/problems/jump-game/
//https://leetcode-cn.com/problems/jump-game-ii/
//给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//canJump判断你是否能够到达最后一个位置。如[2,3,1,1,4]有解，而[3,2,1,0,4]无解
//tested correct on Leetcode

//jump计算最小跳数
//tested correct on Leetcode
public class JumpGame {
    public boolean canJump(int[] nums) {
        int target = nums.length-1;
        int p = 0;
        int maxRange = 0;
        while(p<=maxRange){
            int newRange = nums[p]+p;
            if(maxRange<newRange){
                maxRange = newRange;
            }
            if(newRange>=target){
                return true;
            }
            p++;
        }
        return false;
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
