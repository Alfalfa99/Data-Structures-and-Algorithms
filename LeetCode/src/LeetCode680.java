import java.util.HashMap;

public class LeetCode680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) == s.charAt(j)) {
                continue;
            } else {
                return DFS(s.substring(i+1,j+1)) || DFS(s.substring(i,j));
            }
        }
        return true;
    }

    public static boolean DFS(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++,j--) {
            if (s.charAt(i) == s.charAt(j)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}