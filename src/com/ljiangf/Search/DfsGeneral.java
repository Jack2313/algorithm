package com.ljiangf.Search;

//canFinish
//https://leetcode-cn.com/problems/course-schedule/
//在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//能否完成所有课程的学习

//numIslands
//https://leetcode-cn.com/problems/number-of-islands/comments/
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//此外，你可以假设该网格的四条边均被水包围。


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DfsGeneral {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if(len==0)return true;
        Map<Integer, Integer> keyLock = new HashMap<>();
        Map<Integer, Boolean> isAble = new HashMap<>();
        for(int i=0;i<len;i++){
            keyLock.put(prerequisites[i][0], prerequisites[i][1]);
            isAble.put(prerequisites[i][0], false);
        }
//        for(int i=0;i<len;i++){
//            if(!isAble.containsKey(prerequisites[i][1])){
//                //说明这个开始可以访问到
//                isAble.put(prerequisites[i][1], true);
//            }
//        }
        for(int i=0;i<len;i++){
            Deque<Integer> visited = new LinkedList<>();
            int current = prerequisites[i][0];
            while(!visited.contains(current)){
                if(!isAble.containsKey(current)){
                    //说明current开始就能访问
                    isAble.put(current, true);
                    while(!visited.isEmpty()){
                        isAble.put(visited.peek(), true);
                        visited.pop();
                    }
                    break;
                }else if(isAble.get(current)){
                    while(!visited.isEmpty()){
                        isAble.put(visited.peek(), true);
                        visited.pop();
                    }
                    break;
                }else{
                    if(visited.contains(current)){
                        return false;
                    }
                    visited.push(current);
                    current = keyLock.get(current);
                }
            }
            if(visited.contains(current))return false;
        }
        return true;
    }

    public int numIslands(char[][] grid) {
        int width = grid.length;
        int length = grid[0].length;
        int num = 0;
        for(int i=0;i<width;i++){
            for(int j = 0;j<length;j++){
                if(grid[i][j] == '1'){
                    num++;
                    labelIsland(grid, i, j);
                }else {
                    continue;
                }
            }
        }
        return num;
    }

    private void labelIsland(char[][] grid, int i, int j){
        int width = grid.length;
        int length = grid[0].length;
        if(i<0 ||i>=width){
            return;
        }
        if(j<0 ||j>=length){
            return;
        }
        if(grid[i][j] == '0' || grid[i][j]=='2'){
            return;
        }
        grid[i][j] = '2';
        labelIsland(grid, i-1, j);
        labelIsland(grid, i+1, j);
        labelIsland(grid, i, j-1);
        labelIsland(grid, i, j+1);
    }
}
