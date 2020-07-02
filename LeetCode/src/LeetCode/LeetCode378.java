package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode378 {
    public static void main(String[] args) {

    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int num : row) {
                if (MaxPQ.size() == k && num > MaxPQ.peek()) {
                    break;
                }
                MaxPQ.add(num);
                if (MaxPQ.size() > k) {
                    MaxPQ.remove();
                }
            }
        }
        return MaxPQ.remove();
    }
}
