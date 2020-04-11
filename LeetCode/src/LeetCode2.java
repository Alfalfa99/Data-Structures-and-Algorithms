import java.util.HashMap;

public class LeetCode2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
        ListNode p = addTwoNumbers(l1, l2);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.next == null && p2.next != null){
                p1.next = new ListNode(0);
            } else if (p1.next != null && p2.next == null){
                p2.next = new ListNode(0);
            }
            p1.val = p1.val+p2.val;
            if (p1.val >= 10){
                p1.val-=10;
                if (p1.next == null && p2.next == null){
                    p1.next = new ListNode(1);
                    return l1;
                }
                p1.next.val+=1;
            }
            p1 = p1.next;
            p2 = p2.next;

        }
        return l1;
    }
}
