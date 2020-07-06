package LeetCode;

public class LeetCode114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    TreeNode pre = null;
    void helper(TreeNode root) {
        if(root==null) {
            return;
        }
        //右节点-左节点-根节点 这种顺序正好跟前序遍历相反
        //用pre节点作为媒介，将遍历到的节点前后串联起来
        helper(root.right);
        helper(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }
}
