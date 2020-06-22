public class LeetCode124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }
    static int max_num = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        DFS(root);
        return max_num;
    }

    public static int DFS(TreeNode root){
        if (root == null){
            return 0;
        }
        //后序遍历然后返回经过当前节点的最大值
        //如果左子树是负的或右子树是负的就不选
        int leftVal = Math.max(DFS(root.left),0);
        int rightVal = Math.max(DFS(root.right),0);
        max_num = Math.max(max_num,leftVal+root.val+rightVal);
        return root.val+Math.max(leftVal,rightVal);
    }
}