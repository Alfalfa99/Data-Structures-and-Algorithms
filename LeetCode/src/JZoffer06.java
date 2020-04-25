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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        return helper(head,0,null);
    }
    public static int[] helper(ListNode head, int num,int[] nums){
        if (head != null && head.next != null){
            num++;
            nums = helper(head.next,num,nums);
        } else if (head == null){
            return new int[0];
        } else {
            num++;
            nums = new int[num];
            nums[num-nums.length] = head.val;
            return nums;
        }
        nums[nums.length-num] = head.val;
        return nums;
    }

}
