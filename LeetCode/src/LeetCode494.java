public class LeetCode494 {
    public static void main(String[] args) {

    }

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 如果整个数组的数之和还小于目标值,说明肯定没有任何一种可能性
        if (Math.abs(S) > Math.abs(sum)) {
            return 0;
        }

        int len = nums.length;
        int t = sum * 2 + 1;
        int[][] dp = new int[len][t];
        //初始化
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {
                //边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] = dp[i - 1][r];
            }
        }
        return dp[len - 1][sum + S];
    }
}