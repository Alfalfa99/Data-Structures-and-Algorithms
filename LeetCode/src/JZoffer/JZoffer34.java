package JZoffer;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 苜蓿
 * @date 2020/5/11
 */
public class JZoffer34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
//        root.right.right = new Tree.TreeNode(4);
        root.left.left.left = new TreeNode(-1);
//        root.left.left.right = new Tree.TreeNode(2);
//        root.right.right.left = new Tree.TreeNode(5);
//        root.right.right.right = new Tree.TreeNode(1);
//        Tree.TreeNode root = new Tree.TreeNode(-2);
//        root.right = new Tree.TreeNode(-3);
        System.out.println(pathSum(root, -1));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        helper(lists, list, root, sum);
        return lists;
    }

    public static List<Integer> helper(List<List<Integer>> lists, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (sum != root.val || root.left !=null || root.right != null) {
            list = helper(lists, list, root.left, sum-root.val);
            list = helper(lists, list, root.right, sum-root.val);
        }
        if (sum == root.val && root.left == null && root.right == null) {
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                list1.add(list.get(i));
            }
            lists.add(list1);
            list.remove(list.size() - 1);
            return list;
        }
        list.remove(list.size()-1);
        return list;
    }
}
