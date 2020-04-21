public class LeetCode509 {
    public static void main(String[] args) {
        System.out.println(fib(30));
    }

    public static int fib(int N) {
        int[] dp = new int[N+1];
        if (N <= 1){
            return N;
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[N];
    }
}