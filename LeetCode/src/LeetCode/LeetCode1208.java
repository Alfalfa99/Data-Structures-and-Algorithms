package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1208 {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int nowCost = 0;
        while(right < s.length()) {
            int cost = Math.abs(s.charAt(right) - t.charAt(right));
            nowCost += cost;
            if (nowCost > maxCost) {
                nowCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
                right++;
            }
            else {
                right++;
            }
        }

        return right - left;
    }
}