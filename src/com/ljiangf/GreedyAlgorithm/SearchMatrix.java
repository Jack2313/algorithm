package com.ljiangf.GreedyAlgorithm;
//https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
//tested correct on Leetcode
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;
        int row = matrix.length-1;
        while(row != -1){
            if(matrix[row][col] > target){
                --row;
                if(row == -1){
                    return false;
                }
            }else if(matrix[row][col] < target){
                ++col;
                if(col == matrix[0].length){
                    --col;
                    --row;
                }
            }else{
                return true;
            }
        }
        return false;
    }
}
