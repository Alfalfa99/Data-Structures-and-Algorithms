import java.util.Arrays;
import java.util.Comparator;

public class JZoffer45 {
    public static void main(String[] args){
        int[] nums = new int[]{3,30,34,9,5};
        System.out.println(minNumber(nums));
    }

    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y)-> (x+y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}