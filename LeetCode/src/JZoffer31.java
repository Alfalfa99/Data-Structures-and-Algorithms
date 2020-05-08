import java.util.Stack;

public class JZoffer31 {
    public static void main(String[] args) {

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        if (length == 0){
            return true;
        }

        Stack<Integer> stack = new Stack();
        int j = 0;
        for(int x : pushed){
            stack.push(x);
            while (!stack.isEmpty() && j < length && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == length;
    }
}
