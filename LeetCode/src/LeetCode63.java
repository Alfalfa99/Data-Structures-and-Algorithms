public class LeetCode63 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(nums));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int[][] dp = obstacleGrid;
        if (dp[0][0] == 1){
            return 0;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (dp[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j != 0){
                    if (dp[i][j-1] == 0){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else if (i != 0 && j == 0){
                    if (dp[i-1][j] == 0){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else if (i == 0 && j == 0){
                    dp[i][j] = 1;
                } else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
