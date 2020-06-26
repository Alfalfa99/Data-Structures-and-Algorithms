package LeetCode;

public class LeetCode98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(isValidBST(root));
    }

    static long pre = Long.MIN_VALUE;
    /**
     * 解题思路:前序遍历的结果是:左子节点-当前节点-右子节点,很显然在二叉搜索树中,左,中,右肯定是个增序列
     * 所以我们维护一个遍历中前一个节点的值,如果当前值小于前一个节点的值,说明肯定不是搜索树
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}
