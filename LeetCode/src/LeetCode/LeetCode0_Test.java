package LeetCode;

import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        midInterator(root, res);
        return res;
    }

    public void midInterator(TreeNode node, List<Integer> res){
        if(null == node){
            return;
        }
        midInterator(node.left, res);
        res.add(node.val);
        midInterator(node.right,res);
        return;
    }
}
