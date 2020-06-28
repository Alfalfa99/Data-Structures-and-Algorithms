package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import util.TreeNode;
/**
 * @author 苜蓿
 * @date 2020/5/13
 */
public class LeetCode297 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String str = serialize(root);
        System.out.println(str);
        root = deserialize(str);
        System.out.println(root.val);
    }

    public static String serialize(TreeNode root) {
        return helpSerialize(root, "");
    }

    public static String helpSerialize(TreeNode root, String str){
        if (root == null){
            str+="null,";
            return str;
        } else{
            str += root.val+",";
            str = helpSerialize(root.left,str);
            str = helpSerialize(root.right,str);
        }
        return str;
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] StrData = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(StrData));
        return buildTree(list);
    }

    public static TreeNode buildTree(List<String> list){
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = buildTree(list);
        root.right = buildTree(list);
        return root;
    }
}
