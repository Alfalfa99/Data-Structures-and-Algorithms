import java.util.*;

public class JZoffer32 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        for (List<Integer> list : levelOrder4(root)) {
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

    public static int[] levelOrder1(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            arrayList.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        int[] nums = new int[arrayList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arrayList.get(i);
        }
        return nums;
    }


    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                linkedList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            lists.add(linkedList);
        }
        return lists;
    }

    public static List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                linkedList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if (flag == true){
                Collections.reverse(linkedList);
            }
            flag = !flag;
            lists.add(linkedList);
        }
        return lists;
    }

    public static List<List<Integer>> levelOrder4(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> lists = new LinkedList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        boolean flag = true;
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> list = new LinkedList<>();
            if (flag){
                while (!stack1.isEmpty()){
                    TreeNode treeNode = stack1.pop();
                    list.add(treeNode.val);
                    if (treeNode.left != null){
                        stack2.push(treeNode.left);
                    }
                    if (treeNode.right != null){
                        stack2.push(treeNode.right);
                    }
                }
            } else {
                while (!stack2.isEmpty()){
                    TreeNode treeNode = stack2.pop();
                    list.add(treeNode.val);
                    if (treeNode.right != null){
                        stack1.push(treeNode.right);
                    }
                    if (treeNode.left != null){
                        stack1.push(treeNode.left);
                    }
                }
            }
            lists.add(list);
            flag = !flag;
        }
        return lists;
    }
}
