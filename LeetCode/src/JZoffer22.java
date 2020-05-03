public class JZoffer22 {
    public static void main(String[] args) {

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while (p != null){
            count++;
            p = p.next;
        }
        p = head;
        while (p != null){
            if (count == k){
                return p;
            }
            count--;
            p = p.next;
        }
        return null;
    }
}
