import java.util.List;

public class JZoffer03 {
    public static void main(String[] args) {
    }


    //直接打表,没什么好说的
    public int findRepeatNumber(int[] nums) {
        int[] num = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            num[nums[i]]++;
            if (num[nums[i]]>1){
                return nums[i];
            }
        }
        return 0;
    }
}
