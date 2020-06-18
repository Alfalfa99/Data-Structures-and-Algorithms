import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode1028 {
    public static void main(String[] args) {
        recoverFromPreorder("1-2--3999--4-5--6--7");
    }

    public static TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); ) {
            //查看在第几层，从0开始的，根节点是第0层
            int level = 0;
            while (S.charAt(i) == '-') {
                //通过统计"-"的个数判断下一个数在第几层
                level++;
                i++;
            }
            //查看当前数字
            int val = 0;
            while (i < S.length() && S.charAt(i) != '-') {
                //得到当前的数字,每一位都要*1个10
                val = val * 10 + (S.charAt(i) - '0');
                i++;
            }

            //找到新结点的父节点,父节点就是stack中的最后存储的节点
            while (stack.size() > level) {
                stack.pollLast();
            }
            //创建子结点
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                //如果节点只有一个子节点，那么保证该子节点为左子节点。
                if (stack.peekLast().left == null) {
                    stack.peekLast().left = node;
                } else {
                    stack.peekLast().right = node;
                }
            }
            //入栈
            stack.addLast(node);
        }
        //除了根节点，其他子节点全部出栈
        while (stack.size() > 1) {
            stack.pollLast();
        }
        //返回根节点
        return stack.pollLast();
    }
}