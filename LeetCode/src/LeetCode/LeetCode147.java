package LeetCode;

import util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode147 {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode virtual_head = new ListNode(Integer.MIN_VALUE);
        virtual_head.next = head;
        ListNode cur = virtual_head.next;
        ListNode pre = virtual_head;
        while (cur != null) {
            if (cur.val < pre.val) {
                ListNode nowPre = virtual_head;
                ListNode nowCur = virtual_head.next;
                while (nowCur != cur && nowCur.val < cur.val) {
                    nowCur = nowCur.next;
                    nowPre = nowPre.next;
                }
                pre.next = cur.next;
                nowPre.next = cur;
                cur.next = nowCur;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return virtual_head.next;
    }
}
