package com.ljiangf.DataStructure;
// https://leetcode-cn.com/problems/min-stack/
// 最小栈
// 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//push(x) —— 将元素 x 推入栈中。
//pop()—— 删除栈顶的元素。
//top()—— 获取栈顶元素。
//getMin() —— 检索栈中的最小元素。


import java.util.*;

class MinStack {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        int min = minStack.peek();
        if(min > val){
            min = val;
        }
        xStack.push(val);
        minStack.push(min);
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
