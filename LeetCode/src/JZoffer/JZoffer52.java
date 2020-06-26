package JZoffer;

public class JZoffer52 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7};
        System.out.println();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA,p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null?headB:p1.next;
            p2 = p2 == null?headA:p2.next;
        }
        return p1;
    }
}