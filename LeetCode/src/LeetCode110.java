public class LeetCode110 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.left.left = new TreeNode(5);
//        p.left.right = new TreeNode(3);
//        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(6);
        p.right.right.right = new TreeNode(7);
//        p.right.right.right.right = new TreeNode(1222);
        System.out.println(isBalanced(p));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return degui(root) != -1;
    }

    public static int degui(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = degui(root.left);
        if (left == -1) {
            return -1;
        }
        int right = degui(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}