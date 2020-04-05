import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode108 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
//        p.left.left = new TreeNode(3);
//        p.left.right = new TreeNode(3);
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid, left, right;
        right = nums.length - 1;
        if (nums.length % 2 == 0) {
            mid = nums[nums.length / 2] > nums[nums.length / 2 + 10] ? nums.length / 2 : nums.length / 2 + 1;
        } else {
            mid = nums.length / 2;
        }
        left = mid - 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(new TreeNode(nums[mid]));
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < ; i++) {
                
            }
        }
    }
}