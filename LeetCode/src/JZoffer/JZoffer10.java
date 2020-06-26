package JZoffer;

public class JZoffer10 {

    /**
     * 10-1 斐波那契数列
     */
    public static int fib(int N) {
        int[] dp = new int[N+1];
        if (N <= 1){
            return N;
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+dp[i-2] % 1000000007;
        }
        return dp[N];
    }

    /**
     * 10-2 跳楼梯问题
     */
    public static int numWays(int n) {
        int[] dp = new int[n+1];
        if(n <= 1){
            return 1;
        } else if(n == 2){
            return 2;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] +dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

}
