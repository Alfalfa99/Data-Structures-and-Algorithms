package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import util.TreeNode;
public class LeetCode173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }

    static class BSTIterator {
        Deque<Integer> queue;

        public BSTIterator(TreeNode root) {
            queue = new ArrayDeque<>();
            helper(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return queue.pollFirst();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            if (queue.isEmpty()) {
                return false;
            }
            return true;
        }

        //递归将整个二叉搜索树通过中序遍历放入双端队列queue中
        public void helper(TreeNode root) {
            if (root == null) {
                return;
            }
            helper(root.left);
            queue.addLast(root.val);
            helper(root.right);
        }
    }
}
