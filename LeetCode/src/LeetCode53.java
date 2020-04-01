public class LeetCode53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int Sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            Sum = Math.max(nums[i],Sum);
        }
        return Sum;
    }
}
