package JZoffer;

public class JZoffer28 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
//        p.left.left = new util.TreeNode(3);
        p.left.right = new TreeNode(3);
//        p.right.left = new util.TreeNode(4);
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
        if(root == null){
            return true;
        }
        return helper(root.left,root.right);
    }
    public static boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right,right.left);
    }
}