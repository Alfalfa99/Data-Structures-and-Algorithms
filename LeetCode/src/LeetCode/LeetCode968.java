package LeetCode;

import Tree.TreeNode;

public class LeetCode968 {
    public static void main(String[] args) {

    }
    int result = 0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==1){
            result++;
        }
        return result;
    }
    //0:可被观测但无监控，上一层节点为1
    //1：不可被观测到，上一层节点为2
    //2：有摄像机，上一层节点为0
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftStatus = dfs(root.left),rightStatus = dfs(root.right);
        if(leftStatus==1||rightStatus==1){
            result++;
            return 2;
        }else if(leftStatus==2||rightStatus==2){
            return 0;
        }else{
            return 1;
        }
    }
}
