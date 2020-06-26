package JZoffer;

public class JZoffer18 {
    public static void main(String[] args) {
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head, p2 = head.next;
        if (p1.val == val) {
            head = p2;
            return head;
        }
        while (p2 != null) {
            if (p2.val == val && p2.next != null) {
                p1.next = p2.next;
                return head;
            } else if (p2.val == val && p2.next == null) {
                p1.next = null;
                return head;
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return head;
    }
}
