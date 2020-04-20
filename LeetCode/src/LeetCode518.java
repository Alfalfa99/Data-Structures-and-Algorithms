import java.util.Arrays;

public class LeetCode518 {
    public static void main(String[] args) {
        int[] coins = new int[]{10};
        System.out.println(change(10,coins));
    }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        dp[0][0] = 1;
        for (int i = coins[0]; i <= amount; i++) {
            dp[0][i] = dp[0][i-coins[0]];
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];

        /**
         * 压缩后
         * int[] dp = new int[amount + 1];
         *         dp[0] = 1;
         *
         *         for (int coin : coins) {
         *             for (int x = coin; x < amount + 1; ++x) {
         *                 dp[x] += dp[x - coin];
         *             }
         *         }
         *         return dp[amount];
         */
    }
}