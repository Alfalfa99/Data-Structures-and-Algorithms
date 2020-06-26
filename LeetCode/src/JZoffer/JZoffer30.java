package JZoffer;

import java.util.Stack;

public class JZoffer30 {
    public static void main(String[] args) {

    }


    class MinStack {
        Stack<Integer> stack;
        int min;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(min >= x){
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if(min == stack.pop()){
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}