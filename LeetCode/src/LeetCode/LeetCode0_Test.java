package LeetCode;

import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {
        TreeNode treeA = new TreeNode(9);
        treeA.left = new TreeNode(-1);
        treeA.left.left = new TreeNode(-2);
        treeA.left.right = new TreeNode(0);
        treeA.left.left.left = new TreeNode(-4);
        treeA.left.right.right = new TreeNode(8);
        treeA.left.right.right.left = new TreeNode(6);
        treeA.left.right.right.left.right = new TreeNode(7);
        treeA.left.left.left.left = new TreeNode(-5);
        treeA.left.left.left.right = new TreeNode(-3);
        treeA.right = new TreeNode(2);
        TreeNode treeB = new TreeNode(-1);
        treeB.left=new TreeNode(-2);
        treeB.right = new TreeNode(0);
        treeB.right.right = new TreeNode(8);
        treeB.right.right.left = new TreeNode(6);
        treeB.right.right.left.right = new TreeNode(7);
        mergeTrees(treeA,treeB);
        System.out.println(treeA.left.val);
        return;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        dfs(t1, t2);
        return t1;
    }

    public static void dfs(TreeNode t1, TreeNode t2) {
        t1.val += t2.val;
        if (t1.left == null && t2.left != null) {
            t1.left = t2.left;
            return;
        } else if (t1.right == null && t2.right != null) {
            t1.right = t2.right;
            return;
        }
        if (t1.left != null && t2.left != null) {
            dfs(t1.left, t2.left);
        }
        if (t1.right != null && t2.right != null) {
            dfs(t1.right, t2.right);
        }
    }
}
