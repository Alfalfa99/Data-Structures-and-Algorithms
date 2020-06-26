package JZoffer;

public class JZoffer55_2 {


    public boolean isBalanced(TreeNode root) {
        return helper(root, 0) < 10001;
    }

    public int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (Math.abs(left - right) > 1) {
            return 10001;
        } else {
            return Math.max(left, right);
        }
    }
}
