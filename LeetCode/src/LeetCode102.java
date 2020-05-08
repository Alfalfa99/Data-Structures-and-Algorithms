import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> linkedList = new LinkedList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();
                linkedList.add(treeNode.val);
                if (treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            lists.add(linkedList);
        }
        return lists;
    }

}
