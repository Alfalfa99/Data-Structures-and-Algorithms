package ms;

import util.ListNode;

import java.util.HashMap;

/**
 * @author 苜蓿
 * @date 2020/6/22
 */
public class ms02_01 {
    public static void main(String[] args) {

    }
    HashMap<Integer,Integer> map = new HashMap<>();
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode p1 = head, p2 = head.next;
        map.put(p1.val,0);
        while (p2 != null){
            if (map.containsKey(p2.val)){
                p1.next = p2.next;
                p2 = p2.next;
            }else {
                map.put(p2.val,0);
                p1 = p2;
                p2 = p2.next;
            }
        }
        return head;
    }
}
