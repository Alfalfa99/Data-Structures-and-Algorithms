package SortMethod;


public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 7, 3, 5};
        selectSort(nums);
        for (int num : nums) {
            System.out.printf("%d   ", num);
        }
    }

    public static void selectSort(int[] nums) {
        //数组长度
        int size = nums.length;
        int temp;

        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            for (int num : nums) {
                System.out.printf("%d   ", num);
            }
            System.out.println();
            System.out.println("------");
        }
    }
}

