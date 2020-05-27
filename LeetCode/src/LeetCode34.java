public class LeetCode34 {
    public static void main(String[] args) {

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int left = helper(nums,target-1);
        int right = helper(nums,target);
        //判断target长度,如果长度为0 则返回[-1,-1]
        if(right - left == 0){
            return res;
        } else{
            res[0] = left;
            //因为right记录的是第一个比target大的数的下标,所以要right-1
            res[1] = right - 1;
        }
        return res;
    }

    public static int helper(int[] nums, int target){
        int l = 0, r = nums.length-1;
        //[l,r]区间
        while (l <= r){
            int mid = (l+r)/2;
            if (nums[mid] <= target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}
