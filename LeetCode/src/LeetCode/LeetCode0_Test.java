package LeetCode;

import util.ListNode;
import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,3,4,5,6,7}));
    }

    public static boolean canPartition(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        //初始化
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j == nums[i]) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
