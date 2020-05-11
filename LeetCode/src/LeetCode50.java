/**
 * @author 苜蓿
 * @date 2020/5/11
 */
public class LeetCode50 {
    public static void main(String[] args) {
        System.out.println(myPow(2.1,3));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        return n > 0 ? helper(x, n) : 1.0 / helper(x, n);
    }

    public static double helper(double x, int M) {
        if (M == 0) {
            return 1.0;
        }
        double y = helper(x, M / 2);
        return M % 2 == 0 ? y * y : y * y * x;
    }
}
