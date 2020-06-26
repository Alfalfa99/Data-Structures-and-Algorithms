package LeetCode;

public class LeetCode141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new util.ListNode(0);
//        head.next.next.next = new util.ListNode(4);
        System.out.println((hasCycle(head)));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head.next;
        ListNode p2 = head;
        while (p1 != null && p1.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return false;
    }
}