package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode739 {
    public static void main(String[] args) {
        int[] temp = new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        for (int i : dailyTemperatures(temp)) {
            System.out.println(i);
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int current_num = T[i];
            while (!stack.isEmpty() && current_num > T[stack.peekLast()]) {
                int target = stack.pollLast();
                result[target] = i - target;
            }
            stack.addLast(i);
        }
        return result;
    }
}
