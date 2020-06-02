import java.util.HashMap;

public class JZoffer57_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{16,16,18,24,30,32};
        nums = twoSum(nums,48);
        System.out.println(nums[0] +"  "+ nums[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{nums[i],target-nums[i]};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
