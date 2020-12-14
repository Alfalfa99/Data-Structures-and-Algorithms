package LeetCode;

import java.util.Stack;

public class LeetCode155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }


    static class MinStack {
        Stack<Integer> minStack;
        Stack<Integer> listStack;
        /** initialize your data structure here. */
        public MinStack() {
            minStack = new Stack<>();
            listStack = new Stack<>();
        }
        public void push(int x) {
            if(minStack.isEmpty()){
                minStack.push(x);
            } else if(minStack.peek() >= x){
                minStack.push(x);
            }
            listStack.push(x);
        }

        public void pop() {
            if(minStack.peek().equals(listStack.pop())){
                minStack.pop();
            }
        }

        public int top() {
            return listStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}