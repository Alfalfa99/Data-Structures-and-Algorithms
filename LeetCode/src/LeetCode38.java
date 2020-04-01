public class LeetCode38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }

    public static String countAndSay(int n) {
        String start = "1";
        return run(start, n - 1);
    }

    public static String run(String s, int time) {
        if (time == 0) {
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(n - 1));
        return run(sb.toString(), time - 1);
    }

}
