package JZoffer;

public class JZoffer25 {
    public static void main(String[] args) {
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2,p3 = null;
        return helper(p1,p2,p3);
    }

    public static ListNode helper(ListNode p1, ListNode p2, ListNode p3){
        if(p1 == null){
            return p2;
        } else if(p2 == null){
            return p1;
        }
        if (p1.val <= p2.val){
            p3 = p1;
            p3.next = helper(p1.next,p2,p3.next);
        } else {
            p3 = p2;
            p3.next = helper(p1,p2.next,p3.next);
        }
        return p3;
    }
}
