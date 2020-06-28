package LeetCode;

public class LeetCode209 {
    public static void main(String[] args) {
        int[] nums = new int[]{2};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int nLen = nums.length;
        int left = 0, right = 0;
        //存储当前符合条件的连续子数组的长度
        int minLen = Integer.MAX_VALUE;
        //计算当前滑窗内数之和
        int curCount = 0;
        while (right < nLen) {
            //如果当前滑窗内的数小于s,则右边界右移
            if (curCount < s) {
                curCount += nums[right];
                right++;
            }
            //如果当前滑动窗口内的和大于s,则左边界右移
            while (curCount >= s) {
                minLen = Math.min(minLen, right - left);
                curCount -= nums[left];
                left++;
            }
        }
        //判断是否有目标连续子数组,如果没有就直接返回0
        return minLen == Integer.MAX_VALUE?0:minLen;
    }
}
