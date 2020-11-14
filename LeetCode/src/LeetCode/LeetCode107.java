package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode107 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
//        p.left.left = new Tree.TreeNode(3);
//        p.left.right = new Tree.TreeNode(3);
        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(7);
        for (List<Integer> list : levelOrderBottom(p)) {
            System.out.println(list);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                linkedList.offer(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            list.offerFirst(linkedList);
        }
        return list;
    }
}