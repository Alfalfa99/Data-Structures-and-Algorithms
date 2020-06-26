package JZoffer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JZoffer09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
    static class CQueue {
        ArrayDeque<Integer> stack1;
        ArrayDeque<Integer> stack2;
        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.addLast(stack1.pollLast());
                }
                if (stack2.isEmpty()) {
                    return -1;
                }
            }
            return stack2.pollLast();
        }
    }
}
