package JZoffer;

public class JZoffer26 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(2);
        TreeNode B = new TreeNode(3);
        B.left = new TreeNode(1);
        String s = String.valueOf(123);
        System.out.println(s.length());
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!= null && B!= null) && (helpler(A,B) || isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    public static boolean helpler(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        } else if (A == null || A.val != B.val) {
            return false;
        }
        return helpler(A.left,B.left) && helpler(A.right,B.right);
    }
}