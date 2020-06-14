public class JZoffer16 {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        return n > 0 ? helper(x, n) : 1.0 / helper(x, n);
    }

    public static double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double temp = helper(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }
}
