package ms;

import util.ListNode;

import java.util.HashMap;

/**
 * @author 苜蓿
 * @date 2020/6/22
 */
public class ms08_03 {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i == nums[i]){
                return i;
            }
        }
        return -1;
    }
}
