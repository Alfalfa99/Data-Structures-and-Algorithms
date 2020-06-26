package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            max = Math.max(max, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return max;
    }
}
