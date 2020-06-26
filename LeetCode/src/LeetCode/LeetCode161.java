package LeetCode;

public class LeetCode161 {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] a = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = a.length - 1; i >= 0; i--) {
            if (!a[i].equals("")) {
                sb.append(a[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
