public class LeetCode221 {
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        /**
         * 例子如下, dp数组比matrix多一行和一列,dp中记录的是最大边长
         * matrix:                   dp:
         *  1   1   1   0   1           0   0   0   0   0   0
         *  1   1   1   1   0           0   1   1   1   0   1
         *  1   1   1   0   1           0   1   2   2   1   0
         *  1   1   1   1   1           0   1   2   3   0   1
         *  1   1   0   1   1           0   1   2   3   1   1
         *                              0   1   2   0   1   2
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int width = matrix[0].length;
        int height = matrix.length;
        //正方形最大边长
        int maxSide = 0;
        //多申请一行和一列,就能处理下标为0的情况了
        //dp数组中存的是能形成正方形的最大边长
        int[][] dp = new int[height + 1][width + 1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //如果在字符数组中为1,那么在当前位置的右下角计算当前的最长正方形边长
                if (matrix[i][j] == '1') {
                    //木桶原理,从左下,当前,右 三个位置找到最短的正方形边+1,即为当前位置在右下位置能形成的最大正方形;
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    //根据条件更新最大值;
                    maxSide = Math.max(dp[i + 1][j + 1], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }
}