public class JZoffer06 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        int[] num = reversePrint(head);
        for (int i : num) {
            System.out.println(i);
        }
    }

    static int[] result;
    public static int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }
        helper(head, 0);
        return result;
    }
    public static int helper(ListNode head, int depth){
        int i;
        if(head.next == null){
            result = new int[depth+1];
            i = 0;
        } else{
            i = helper(head.next, depth+1);
        }
        result[i] = head.val;
        return i+1;
    }

}
