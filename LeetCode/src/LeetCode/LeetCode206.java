package LeetCode;

public class LeetCode206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head = reverseList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        } else if (head.next == null){
            return head;
        }
        return helper(head,head.next,null);
    }

    public static ListNode helper(ListNode p1, ListNode p2,ListNode tail){
        if (p2.next != null) {
            tail = helper(p2, p2.next,null);
            p2.next = p1;
        }else {
            p2.next = p1;
            tail = p2;
            p1.next = null;
            return tail;
        }
        p1.next = null;
        return tail;
    }


}
