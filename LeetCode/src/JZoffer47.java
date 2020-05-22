public class JZoffer47 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,5},{3,2,1}};
        System.out.println(maxValue(nums));
    }

    public static int maxValue(int[][] grid) {
        int length1 = grid.length, length2 = grid[0].length;
        for (int i = 1; i < length2; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < length1; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[length1 - 1][length2 - 1];
    }
}