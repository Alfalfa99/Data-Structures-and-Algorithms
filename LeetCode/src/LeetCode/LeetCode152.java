package LeetCode;

public class LeetCode152 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = max;
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                max = Math.max(nums[j], max);
                dp[j] = i == j ? nums[j] * nums[j - 1] : dp[j - 1] * nums[j];
                max = Math.max(dp[j], max);
            }
        }
        return max;

        /**
         * 参考答案
         *         int max = Integer.MIN_VALUE, imax = 1, imin = 1;
         *         for(int i=0; i<nums.length; i++){
         *             if(nums[i] < 0){ //如果当前数为负数,则将当前的最大值和最小值做交换,这样乘出来的值就是正确的最大最小值
         *                  int tmp = imax;
         *                  imax = imin;
         *                  imin = tmp;
         *             }
         *             imax = Math.max(imax*nums[i], nums[i]);
         *             imin = Math.min(imin*nums[i], nums[i]);
         *
         *             max = Math.max(max, imax);
         *         }
         *         return max;
         */
    }
}
