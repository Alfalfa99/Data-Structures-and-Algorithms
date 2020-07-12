package LeetCode;

public class LeetCode174 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(nums));
    }

    /**
     * 动态规划,从右下(dp[m-1][n-1]往左上递归)
     * -2 -3  3              7  5  2
     * -5 -10 1              6  11 5
     * 10 30 -5              1  1  6
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        //如果这一格的值大于等于0,那么来到这一格的条件是至少有一滴血,如果小于0,那么来到这一格就需要(1 - 该格的值)的血量
        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        for(int i = m - 2; i >= 0; i--){
            //最后一列只能由上一列走到,同理,如果这一格的值大于等于0,那么来到这一格的条件是至少有一滴血,
            // 如果小于0,那么来到这一格就需要(上一列的值 - 该格的值)的血量
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }
        for(int i = n - 2; i >= 0; i--){
            //最后一行只能由前一行走到,同理,如果这一格的值大于等于0,那么来到这一格的条件是至少有一滴血,
            // 如果小于0,那么来到这一格就需要(上一行的值 - 该格的值)的血量
            dp[m-1][i] = Math.max(1, dp[m-1][i+1] - dungeon[m-1][i]);
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                //计算到前一个格子所需要的最少的血
                int dpmin = Math.min(dp[i+1][j], dp[i][j+1]);
                //同理,如果这一格的值大于等于0,那么来到这一格的条件是至少有一滴血,
                // 如果小于0,那么来到这一格就需要(到前一个格子所需的最少血量 - 该格的值)的血量
                dp[i][j] = Math.max(1, dpmin - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
