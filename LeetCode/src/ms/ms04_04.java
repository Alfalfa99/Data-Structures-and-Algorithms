package ms;

import Tree.TreeNode;

/**
 * @author 苜蓿
 * @date 2020/6/22
 */
public class ms04_04 {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return helper(root, 0) == Integer.MAX_VALUE? false:true;
    }

    public int helper(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        int leftVal = helper(root.left, depth+1);
        int rightVal = helper(root.right, depth+1);
        if (Math.abs(leftVal - rightVal) > 1){
            return Integer.MAX_VALUE;
        } else {
            return Math.max(leftVal,rightVal);
        }
    }
}
