public class LeetCode104 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
//        p.left.left = new TreeNode(3);
//        p.left.right = new TreeNode(3);
        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(7);
        System.out.println(maxDepth(p));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static int maxDepth(TreeNode root) {
        return degui(root, 0);
    }

    public static int degui(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        count++;
        return Math.max(degui(root.left, count),degui(root.right, count));
    }
}