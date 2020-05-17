import java.util.PriorityQueue;
import java.util.Queue;

public class JZoffer42 {
    public static void main(String[] args){

    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > 0){
                nums[i]+=nums[i-1];
            }
            max = Math.max(nums[i],max);
        }
        return max;
    }
}