package LeetCode;

import util.ListNode;
import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {

    }
    static ListNode realHead;
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        dfs(head, head.next);
        return realHead;
    }
    public static void dfs(ListNode pre, ListNode cur) {
        if(cur == null){
            return;
        }
        dfs(cur, cur.next);
        realHead = cur;
        cur.next = pre;
        pre.next = null;
    }
}
