package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode108 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
//        p.left.left = new Tree.TreeNode(3);
//        p.left.right = new Tree.TreeNode(3);
        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(7);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int nums[];

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        this.nums = nums;
        return degui(0, nums.length - 1);
    }

    public TreeNode degui(int left, int right) {
        if (left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(this.nums[mid]);
        treeNode.left = degui(left,mid-1);
        treeNode.right = degui(mid+1,right);
        return treeNode;
    }
}