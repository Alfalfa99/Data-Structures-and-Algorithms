package LeetCode;


import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
<<<<<<< Updated upstream
    Deque<Node> curNodeQueue = new ArrayDeque<>();
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        curNodeQueue.add(root);
        int size = curNodeQueue.size();
        while(size != 0){
            Node curNode = null;
            for (int i = 0; i < size; i++) {
                Node node = curNodeQueue.pollFirst();
                if(node.left != null){
                    curNodeQueue.add(node.left);
                }
                if(node.right != null){
                    curNodeQueue.add(node.right);
                }
                if(curNode != null){
                    curNode.next = node;
                }
                curNode = node;
=======
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'a'}};
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
>>>>>>> Stashed changes
            }
            size = curNodeQueue.size();
            curNode = null;
        }
<<<<<<< Updated upstream
        return root;
=======
>>>>>>> Stashed changes
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}