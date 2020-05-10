public class JZoffer39 {
    public static void main(String[] args){
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }



    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0){
                candidate = num;
            }
            count += (candidate == num)? 1:-1;
        }
        return candidate;
    }

//    public static int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }
}