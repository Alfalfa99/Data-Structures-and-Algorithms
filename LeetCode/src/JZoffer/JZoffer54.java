package JZoffer;

import Tree.TreeNode;

import java.util.PriorityQueue;

public class JZoffer54 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthLargest(root,1));
    }

    static PriorityQueue<Integer> heap;
    private static int kn;
    public static int kthLargest(TreeNode root, int k) {
        heap = new PriorityQueue<>(k);
        kn = k;
        helper(root);
        return heap.poll();
    }

    public static void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (heap.isEmpty() || heap.size() < kn || root.val > heap.peek()){
            heap.offer(root.val);
        }
        if (heap.size() > kn){
            heap.poll();
        }
        helper(root.left);
        helper(root.right);
    }
}