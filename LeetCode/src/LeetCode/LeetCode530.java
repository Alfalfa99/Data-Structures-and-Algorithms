package LeetCode;

import util.TreeNode;

public class LeetCode530 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(getMinimumDifference(root));
    }

    static int min = Integer.MAX_VALUE;
    static TreeNode preNode;

    public static int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (preNode != null) {
            min = Math.min(min, root.val - preNode.val);
        }
        preNode = root;
        inOrder(root.right);
    }
}
