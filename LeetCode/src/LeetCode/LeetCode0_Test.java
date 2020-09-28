package LeetCode;


import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    Deque<Node> curNodeQueue = new ArrayDeque<>();
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        curNodeQueue.add(root);
        int size = curNodeQueue.size();
        while(size != 0){
            Node curNode = null;
            for (int i = 0; i < size; i++) {
                Node node = curNodeQueue.pollFirst();
                if(node.left != null){
                    curNodeQueue.add(node.left);
                }
                if(node.right != null){
                    curNodeQueue.add(node.right);
                }
                if(curNode != null){
                    curNode.next = node;
                }
                curNode = node;
            }
            size = curNodeQueue.size();
            curNode = null;
        }
        return root;
    }
}