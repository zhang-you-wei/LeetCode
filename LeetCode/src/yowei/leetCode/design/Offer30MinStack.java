package yowei.leetCode.design;

import java.util.LinkedList;

/**
 * 最小栈，要求能够O(1)找到栈中最小元素
 * 只用一个栈实现，每次存入元素与min的差值，为负表示新元素小于min，则更新min
 * 取元素时，若出栈的元素为负，表示当前栈中最小元素已经出栈，需要更新min
 */
public class Offer30MinStack {
    LinkedList<Integer> stack;
    int min;
    public Offer30MinStack() {
        this.stack = new LinkedList<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(0);
            min = x;
        }else{
            stack.push(x - min);
            if(x < min){
                min= x;
            }
        }

    }

    public void pop() {
        if(stack.isEmpty()) return;
        int x =  stack.pop();
        if(x < 0){
            min -= x;
        }
    }

    public int top() {
        if(stack.peek() > 0){
            return stack.peek() + min;
        }else{
            return min;
        }

    }

    public int min() {
        return min;
    }
}
