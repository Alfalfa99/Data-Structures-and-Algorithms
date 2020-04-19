public class LeetCode494 {
    public static void main(String[] args) {

    }

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        //
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(S) > sum) {
            return 0;
        }
        int border = sum * 2 + 1;
        int[][] dp = new int[nums.length][border];
        //初始化
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum - nums[0]] = 1;
            dp[0][sum + nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < border; j++) {
                int l = j - nums[i] >= 0 ? j - nums[i] : 0;
                int r = j + nums[i] < border ? j + nums[i] : 0;
                dp[i][j] = dp[i-1][r]+dp[i-1][l];
            }
        }
        return dp[nums.length-1][S+sum];
    }
}