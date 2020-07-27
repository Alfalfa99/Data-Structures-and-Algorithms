package LeetCode;

public class LeetCode392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","adfbfc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null){
            return false;
        }
        int sLen = s.length();
        int tLen = t.length();
        if (tLen < sLen){
            return false;
        }
        int pos = 0;
        while (sLen > pos && tLen > 0){
            int flag = t.indexOf(s.charAt(pos));
            if (flag >= 0) {
                pos++;
                t = t.substring(flag+1);
            } else {
                return false;
            }
        }
        return true;
    }
}
