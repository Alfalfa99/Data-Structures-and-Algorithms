public class LeetCode101 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
//        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(3);
//        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(3);
        System.out.println(isSymmetric(p));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return degui(root.left,root.right);
    }

    public static Boolean degui(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val == r.val){
            return degui(l.left,r.right) && degui(l.right,r.left);
        } else {
            return false;
        }
    }
}