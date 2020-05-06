public class JZoffer27 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root=mirrorTree(root);
        System.out.printf("%d %d %d %d %d %d %d ",root.val,root.left.val,root.right.val,root.left.left.val,
                root.left.right.val,root.right.left.val,root.right.right.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mirrorTree(TreeNode root) {
        TreeNode nroot = null;
        return helper(root,nroot);
    }
    public static TreeNode helper(TreeNode root, TreeNode nroot){
        if (root == null){
            return null;
        }
        nroot = new TreeNode(root.val);
        nroot.right = helper(root.left,nroot.right);
        nroot.left = helper(root.right,nroot.left);
        return nroot;
    }
}