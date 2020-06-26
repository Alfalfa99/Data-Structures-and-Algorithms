package JZoffer;

public class JZoffer05 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy"));
    }

    public static String replaceSpace(String s) {
        int len = s.length();
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' '){
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
