package LeetCode;

import util.TreeNode;

public class LeetCode538 {
    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root, root.val,1);
        return root;
    }

    public int dfs(TreeNode node, int val,int flag) {
        if (null == node) {
            return 0;
        }
        if (flag == 0){
            node.val += val;
        }
        int rValue = dfs(node.right, node.val,1);
        if (flag == 1){
            node.val += rValue;
        }
        int lValue = dfs(node.left, val,0);
        return 0;
    }
}
