package LeetCode;

import java.util.Arrays;

public class LeetCode350 {
    public static void main(String[] args) {

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // 排好序的写法
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 定义i，j两个指针，k用于记录交集的索引值
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                // 说明num1[i]较小，i右移
                i++;
            } else if (nums1[i] > nums2[j]) {
                // 说明nums2[j]较小，j右移
                j++;
            } else {
                // 两个元素相同，记录在k
                nums1[k++] = nums1[i];
                // 两个指针向前走一步
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
