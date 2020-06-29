package LeetCode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode215 {
    public static void main(String[] args) {

    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (heap.isEmpty() || heap.size() < k) {
                heap.offer(nums[i]);
                continue;
            }
            if (heap.peek() < nums[i]){
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }
}
