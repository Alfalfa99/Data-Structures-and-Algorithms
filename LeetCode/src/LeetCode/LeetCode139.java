package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode139 {
    public static void main(String[] args) {
        List<String> workDict = new ArrayList<>();
        workDict.add("aaaa");
        workDict.add("aaa");
        workDict.add("sand");
        workDict.add("and");
        workDict.add("cat");
        System.out.println(wordBreak("sandandcat",workDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        //初始化,因为空串总是字典的一部分
        dp[0] = true;
        //下标i用来表示从当前字符串开始的可能的子字符串
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
