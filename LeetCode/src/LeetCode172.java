public class LeetCode172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(8));
    }


    public static int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}