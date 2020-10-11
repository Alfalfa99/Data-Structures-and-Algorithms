package LeetCode;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LeetCode637 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(averageOfLevels(treeNode));

    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        ArrayDeque<TreeNode> list = new ArrayDeque<>();
        int curLen = 0, nextLen = 0;
        if(root == null){
            return res;
        }
        list.add(root);
        curLen++;
        while(!list.isEmpty()){
            double ave = 0;
            for (int i = 0; i < curLen; i++) {
                TreeNode curNode = list.pollFirst();
                if (curNode.left!=null){
                    list.add(curNode.left);
                    nextLen++;
                }
                if (curNode.right!=null){
                    list.add(curNode.right);
                    nextLen++;
                }
                ave += curNode.val;
            }
            ave = ave/curLen;
            curLen = nextLen;
            nextLen = 0;
            res.add(ave);
        }
        return res;
    }
}
