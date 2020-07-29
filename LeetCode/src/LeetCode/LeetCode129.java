package LeetCode;

import util.TreeNode;

public class LeetCode129 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(0);
//        treeNode.left.right = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        System.out.println(sumNumbers(treeNode));
    }

    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return helper(root.left, temp) + helper(root.right, temp);
    }
}
