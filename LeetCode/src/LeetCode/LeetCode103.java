package LeetCode;

import java.util.*;

public class LeetCode103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        for (List<Integer> list : zigzagLevelOrder(root)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        boolean flag = true;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            if (flag) {
                while (!stack1.isEmpty()) {
                    TreeNode treeNode = stack1.pop();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        stack2.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack2.push(treeNode.right);
                    }
                }
                lists.add(list);
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode treeNode = stack2.pop();
                    list.add(treeNode.val);
                    if (treeNode.right!=null){
                        stack1.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack1.push(treeNode.left);
                    }
                }
                lists.add(list);
            }
            flag = !flag;
        }
        return lists;
    }

}
