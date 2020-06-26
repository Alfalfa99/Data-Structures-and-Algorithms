package JZoffer;

public class JZoffer24 {
    public static void main(String[] args) {
        
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        } else if(head.next == null){
            return head;
        }
        return helper(head,head.next,null);
    }
    public static ListNode helper(ListNode p1,ListNode p2,ListNode tail){
        if(p2.next != null){
            tail = helper(p2,p2.next,tail);
        } else {
            tail = p2;
            p2.next = p1;
            p1.next = null;
            return tail;
        }
        p2.next = p1;
        p1.next = null;
        return tail;
    }
}
