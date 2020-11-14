package ms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 苜蓿
 * @date 2020/6/22
 */
public class ms03_02 {
    public static void main(String[] args) {

    }

    class MinStack {
        Deque<Integer> normalStack;
        Deque<Integer> smallStack;

        /** initialize your data structure here. */
        public MinStack() {
            normalStack = new ArrayDeque<>();
            smallStack = new ArrayDeque<>();
        }
        public void push(int x) {
            if (smallStack.isEmpty() || smallStack.peekLast() >= x){
                smallStack.offerLast(x);
            }
            normalStack.offerLast(x);
        }

        public void pop() {
            if (normalStack.pollLast().equals(smallStack.peekLast())){
                smallStack.pollLast();
            }
        }

        public int top() {
            return normalStack.peekLast();
        }

        public int getMin() {
            return smallStack.peekLast();
        }
    }
}
