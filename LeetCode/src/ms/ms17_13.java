package ms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 苜蓿
 * @date 2020/6/22
 */
public class ms17_13 {
    public static void main(String[] args) {

    }

    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        int m = dictionary.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            for (int j = 0; j < m ; j++) {
                if (i < dictionary[j].length()) {
                    continue;
                }
                if (sentence.substring(i - dictionary[j].length(), i).equals(dictionary[j])) {
                    dp[i] = Math.max(dp[i - dictionary[j].length()] + dictionary[j].length(), dp[i]);
                }
            }
        }
        return n - dp[n];
    }
}
