package JZoffer;

public class JZoffer60 {
    public static void main(String[] args) {

    }

    public double[] twoSum(int n) {
        int[] dp = new int[6*n + 1];
        // 初始赋值
        for (int i = 1; i <= 6; i ++) {
            dp[i] = 1;
        }
        // 2 ~ n 个阶段求解
        for (int i = 2; i <= n; i++) {
            // 每次都从最大的开始求解
            for (int s = 6*i; s >= i; s--) {
                // 这里注意要赋值
                dp[s] = 0;
                for (int d = 1; d <= 6; d++) {
                    if (s - d < i - 1) {
                        break;
                    }
                    dp[s] += dp[s - d];
                }
            }
        }
        double all = Math.pow(6, n);
        double[] res = new double[5*n + 1];
        for (int i = n; i <= 6*n; i++) {
            res[i - n] = dp[i] / all;
        }
        return res;
    }
}
