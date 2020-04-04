public class LeetCode100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(isSameTree(p,q));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;    //如果当前的节点都为null则为true,返回递归上一层
        if (p == null || q == null) return false;   //如果只有一个为null则不同
        if (p.val != q.val) return false;           //如果值不同则不同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);//将两棵树都放入递归
    }
}