import java.util.HashMap;

public class LeetCode1 {
    /**
     *     两数之和,通过HashMap的键存储值,值存储数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            if (map.containsKey(number) && map.get(number)!= i){
                return new int[]{i,map.get(number)};
            }
        }
        throw new IllegalArgumentException(" ");
    }
}
