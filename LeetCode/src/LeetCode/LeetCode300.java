package LeetCode;

public class LeetCode300 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp[]表示i个数最长子序列的长度
        int[] dp = new int[nums.length];
        //初始化整个数组都为1,因为数组中每个数都是自己的子序列,长度为1
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        //记录最长的子序列长度
        int max = dp[0];
        //画表格
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //从i+1开始找,如果找到一个数j,使得nums[j] > num[i],则让dp[j] = dp[i] + 1;
                //但这里有一个问题,如果当前dp[j]作为别的子序列的长度大于当前子序列长度的话,使用最长子序列的长度
                //所以状态转移方程为: dp[j] = Math.max(dp[i]+1,dp[j]);
                //如果dp[j]>max,更新max的值
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
        }
        return max;
    }
}