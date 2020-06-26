package LeetCode;

public class LeetCode64 {
    public static void main(String[] args) {
        int [][]arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(arr));
    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                if (i == 0){
                    dp[i][j] = grid[0][j-1]+grid[0][j];
                } else if (j == 0){
                    dp[i][j] = grid[i-1][0]+grid[i][0];
                } else {
                    dp[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
