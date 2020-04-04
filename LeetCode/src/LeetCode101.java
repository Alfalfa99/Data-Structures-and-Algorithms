public class LeetCode101 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.right.left = new TreeNode(4);
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
        StringBuilder sb = new StringBuilder();
        root = degui(root, sb);
        System.out.println(sb);
        if (sb.length() == 1) {
            return true;
        }
        for (int i = 1; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                System.out.println(sb.charAt(i));
                System.out.println(sb.charAt(i + 1));
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static TreeNode degui(TreeNode p, StringBuilder sb) {
        if (null == p) {
            return p;
        } else {
            sb.append(p.val);
        }
        if (p != null) {
            degui(p.left, sb);
            degui(p.right, sb);
        }
        return p;
    }
}