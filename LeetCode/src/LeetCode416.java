public class LeetCode416 {
    public static void main(String[] args) {

    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        sum /= 2;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = dp[i-1][j] dp[i-1][j-1]
            }
        }
    }
}