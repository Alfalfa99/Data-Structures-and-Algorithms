package LeetCode;

public class LeetCode153 {

    public int findMin(int[] nums) {
        if (nums.length == 0){
            throw new IllegalArgumentException();
        }
        for(int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }

}
