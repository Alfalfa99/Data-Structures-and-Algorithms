public class JZoffer16 {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000,-2));
    }

    public static double myPow(double x, int n) {
        // 要考虑当n是负数的情况。
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        else {
            return myPow(x * x, n / 2) * myPow(x, n - n / 2 * 2);
        }
    }
}
