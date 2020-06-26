package JZoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 苜蓿
 * @date 2020/5/12
 */
public class JZoffer35 {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.random = head;
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        head = copyRandomList(head);
        while (head!=null){
            if (head.random!=null){
                System.out.printf("%d %d \n",head.val,head.random.val);
            } else {
                System.out.printf("%d null \n",head.val);
            }
            head = head.next;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static Map<Node,Node> map = new HashMap<>();
    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node root = new Node(head.val);
        map.put(head,root);
        build(head,root);
        createRandom(head,root);
        return root;
    }

    public static void build(Node head, Node root){
        while (head.next!=null){
            Node nextNode = new Node(head.next.val);
            root.next = nextNode;
            map.put(head.next,nextNode);
            head = head.next;
            root = root.next;
        }
    }

    public static void createRandom(Node head, Node root){
        while (head!=null){
            if (head.random!=null){
                root.random = map.get(head.random);
            }
            head = head.next;
            root = root.next;
        }
    }
}
