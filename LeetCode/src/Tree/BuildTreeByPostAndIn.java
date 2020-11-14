package Tree;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class BuildTreeByPostAndIn {
    public static void main(String[] args) {
        int[] postorder = new int[]{1, 2, 9, 15, 7, 20, 3};
        int[] inorder = new int[]{1, 9, 2, 3, 15, 20, 7};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(inorder, postorder);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                System.out.printf("%d  ", cur.val);
            }
        }
    }

    static class Solution {
        int[] post;
        HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0) {
                return null;
            }
            post = postorder;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return toBuildTree(0, postorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode toBuildTree(int postLeft, int postRight, int inLeft, int inRight) {
            if (postLeft > postRight || inLeft > inRight) {
                return null;
            }
            TreeNode node = new TreeNode(post[postRight]);
            int midPosition = map.get(post[postRight]);
            //后序遍历：假设左子树的右边界为x，计算右子树的长度为[x+1,postRight-1]
            //中序遍历：右子树长度为[mid+1,inRight]
            // postRight-1-(x+1) = inRight - (mid+1)
            node.left = toBuildTree(postLeft, postRight + midPosition - inRight - 1, inLeft, midPosition - 1);
            node.right = toBuildTree(postRight - inRight + midPosition, postRight - 1, midPosition + 1, inRight);
            return node;
        }
    }
}

