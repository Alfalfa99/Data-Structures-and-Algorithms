package LeetCode;

public class LeetCode189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    public static void rotate(int[] nums, int k) {
        if (nums.length == 0){
            return;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k%nums.length-1);
        reverse(nums,k%nums.length,nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end){
        int temp;
        while (start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}