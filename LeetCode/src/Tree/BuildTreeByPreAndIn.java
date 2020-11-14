package Tree;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BuildTreeByPreAndIn {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{3, 9, 1, 2, 20, 15, 7};
        int[] inorder = new int[]{1, 9, 2, 3, 15, 20, 7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
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
        // 使用全局变量是为了让递归方法少传一些参数，不一定非要这么做

        Map<Integer, Integer> reverses;
        int[] preorder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int preLen = preorder.length;
            int inLen = inorder.length;

            // 可以不做判断，因为题目中给出的数据都是有效的
            if (preLen != inLen) {
                return null;
            }

            this.preorder = preorder;

            // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
            reverses = new HashMap<>(inLen);
            for (int i = 0; i < inLen; i++) {
                reverses.put(inorder[i], i);
            }

            return buildTree(0, preLen - 1, 0, inLen - 1);
        }

        /**
         * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
         *
         * @param preL 前序遍历数组的区间左端点
         * @param preR 前序遍历数组的区间右端点
         * @param inL  中序遍历数组的区间左端点
         * @param inR  中序遍历数组的区间右端点
         * @return 构建的新二叉树的根结点
         */
        private TreeNode buildTree(int preL, int preR,
                                   int inL, int inR) {
            if (preL > preR || inL > inR) {
                return null;
            }
            // 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
            int pivot = preorder[preL];
            TreeNode root = new TreeNode(pivot);

            int pivotIndex = reverses.get(pivot);

            //前遍历：假设左子树的右边界为x，计算左子树的长度为[preL+1, x]
            //中序遍历：左子树长度为[inLeft, mid - 1]
            //x - (preL + 1) = mid - 1 - inLeft
            root.left = buildTree(preL + 1, preL + (pivotIndex - inL), inL, pivotIndex - 1);
            root.right = buildTree(preL + (pivotIndex - inL) + 1, preR, pivotIndex + 1, inR);
            return root;
        }

    }
}

