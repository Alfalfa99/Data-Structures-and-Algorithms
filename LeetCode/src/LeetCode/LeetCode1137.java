package LeetCode;

public class LeetCode1137 {
    public static void main(String[] args) {
        System.out.println(tribonacci(3));
    }

    public static int tribonacci(int n) {
        int[] dp = new int[n+1];
        if (n <= 1){
            return n;
        } else if (n == 2){
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}