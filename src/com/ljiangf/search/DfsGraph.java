package com.ljiangf.Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//findSurroundedArea
//https://leetcode-cn.com/problems/surrounded-regions/
//找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//tested correct on Leetcode

//cloneGraph
//https://leetcode-cn.com/problems/clone-graph/
//在内存中完全拷贝一个图
//tested correct on Leetcode

public class DfsGraph {
    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private int len, width;
    private void dfsSearch(char[][] board, int i, int j){
        if(i<0 || j<0)return;
        if(i>=len||j>=width)return;
        if(board[i][j]!='O')return;
        board[i][j]='A';
        dfsSearch(board, i+1,j);
        dfsSearch(board, i-1,j);
        dfsSearch(board, i,j+1);
        dfsSearch(board, i,j-1);
        return;
    }
    public void findSurroundedArea(char[][] board) {
        len = board.length;
        if(len==0) return;
        width = board[0].length;
        for (int i = 0; i < len; i++) {
            dfsSearch(board, i, 0);
            dfsSearch(board, i, width - 1);
        }
        for (int i = 1; i < width - 1; i++) {
            dfsSearch(board, 0, i);
            dfsSearch(board, len - 1, i);
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<width;j++){
                if(board[i][j]=='A'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node==null)return null;
        if(map.containsKey(node)){
            return map.get(node);
        }else{
            Node newNode = new Node();
            newNode.val = node.val;
            map.put(node, newNode);
            for (Node x: node.neighbors) {
                newNode.neighbors.add(cloneGraph(x));
            }
            return newNode;
        }

    }
}
