package LeetCode;

public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n != 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } else if (m != 0 && n == 0) {
            return;
        } else if (m == 0 && n == 0) {
            return;
        }
        int i,j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
            if (nums1[i] > nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
        while (j >= 0){
            nums1[j] = nums2[j];
            j--;
        }
    }
}