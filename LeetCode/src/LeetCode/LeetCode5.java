package LeetCode;

public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcda"));
    }

    /**
     * s = "abcda"
     *
     *  0 1 2 3 4 j
     * 0 T
     * 1 F T
     * 2 F F T
     * 3 F F F T
     * 4 F F F F T
     * i
     * 注意(4,0)虽然s.charAt(4) = s.charAt(0),但不能使dp[i][j] = true
     * 原因:你不能因为首末两个字母相等就说他是回文串,你要从之前的状态dp[i-1][j+1]中进行查询
     * 如果dp[i-1][j+1] == true的话及说明之前的这个子串也是回文串,直接进行子串增长操作即可
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        Boolean[][] dp = new Boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int MaxLen = 1;
        int Start = 0;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    int CurLen = i - j + 1;
                    if (CurLen > MaxLen) {
                        Start = j;
                        MaxLen = CurLen;
                    }
                }
            }
        }
        return s.substring(Start, Start + MaxLen);
    }
}
