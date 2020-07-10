package LeetCode;

public class LeetCode309 {
    public static void main(String[] args) {


    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        /**
         * 第一维表示天数
         * 第二维分别表示如下几种情况:
         *      1) [i][0]:表示正在持股
         *      2) [i][1]:表示正处于冷冻期
         *      3) [i][2]:表示未持股
         */
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            /**
             * 正在持股的两种情况:
             *      1) dp[i-1][0]: 表示之前的股份没有卖出
             *      2) dp[i-1][2] - prices[i]: 表示之前处于冷冻期,这次是新买的股票
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            /**
             * 如果是处于冷冻期那么只有一种情况
             *      1) dp[i-1][0]+prices[i]: 把之前购买的股票在这一天卖掉
             */
            dp[i][1] = dp[i - 1][0] + prices[i];
            /**
             * 未持股存在两种情况:
             *      1) dp[i-1][1]: 表示前一天正处于冷冻期,所以无法持股
             *      2) dp[i-1][2]: 表示前一天也没有持股(不在冷冻期)
             */
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        //最后对不持股状态求最大，因为持股是没有意义的，只能是利润减少。
        return Math.max(dp[n - 1][2], dp[n - 1][1]);
    }
}
