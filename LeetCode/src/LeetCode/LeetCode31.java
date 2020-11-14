package LeetCode;


public class LeetCode31 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 7, 3, 5};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.printf("%d   ", num);
        }

    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length-1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length-1;
        while (left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

