package JZoffer;

public class JZoffer58_2 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcd",4));
    }

    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s.substring(0,n));
        StringBuilder st = new StringBuilder(s.substring(n));
        return st+sb.toString();
    }
}
