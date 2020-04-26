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
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        public void appendTail(int value) {
            stack2.add(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty()){
                if (stack2.isEmpty()){
                    return -1;
                } else {
                    while (!stack2.empty()) {
                        stack1.push(stack2.pop());
                    }
                }
            }
            return stack1.pop();
        }
    }

}
