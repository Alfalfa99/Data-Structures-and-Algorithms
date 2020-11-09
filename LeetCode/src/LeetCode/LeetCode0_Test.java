package LeetCode;


import util.ListNode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,7,3,5};
        quickSort(nums);
        for (int num : nums) {
            System.out.printf("%d   ",num);
        }
    }
    public static void quickSort(int[] nums){
        quickSortImpl(nums,0, nums.length-1);
    }
    public static void quickSortImpl(int[] nums, int low, int high){
        if(low < high){
            int mid = getMid(nums, low, high);
            quickSortImpl(nums,low, mid-1);
            quickSortImpl(nums,mid+1, high);
        }
    }
    public static int getMid(int[] nums,int low, int high){
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] >= temp){
                high--;
            }
            nums[low] = nums[high];
            for (int num : nums) {
                System.out.printf("%d   ",num);
            }
            System.out.println();
            while (low < high && nums[low] <= temp){
                low++;
            }
            nums[high] = nums[low];
            for (int num : nums) {
                System.out.printf("%d   ",num);
            }
            System.out.println();
        }
        nums[low] = temp;
        for (int num : nums) {
            System.out.printf("%d   ",num);
        }
        System.out.println();
        System.out.println("-------------" + low);
        return low;
    }
}

