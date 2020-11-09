package SortMethod;


public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 7, 3, 5};
        insertSort(nums);
        for (int num : nums) {
            System.out.printf("%d   ", num);
        }
    }

    public static void insertSort(int[] nums) {
        int size = nums.length;
        int j;
        for (int i = 0; i < size; i++) {
            int temp = nums[i];
            for (j = i; j > 0 && nums[j - 1] > temp; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
            for (int num : nums) {
                System.out.printf("%d   ", num);
            }
            System.out.println();
            System.out.println("------");
        }

        return;
    }
}

