import java.util.HashMap;

public class JZoffer53 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7};
        System.out.println(search(nums, 8));
    }

    public static int search(int[] nums, int target) {
        //找到最后一个target出现的位置下标 - 第一个target出现的下标 = target出现的次数
        return helper(nums, target) - helper(nums, target-1);
    }

    public static int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}