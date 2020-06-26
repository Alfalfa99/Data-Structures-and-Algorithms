package JZoffer;

public class JZoffer21 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        exchange(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    public static int[] exchange(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length-1;
        while (left < right){
            int temp;
            if (nums[left] % 2 == 0){
                if (nums[right] % 2 != 0){
                    temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return nums;
    }
}
