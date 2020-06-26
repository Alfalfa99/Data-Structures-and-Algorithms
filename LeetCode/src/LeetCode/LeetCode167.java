package LeetCode;

import java.util.HashMap;

public class LeetCode167 {
    public static void main(String[] args) {
        int[] num = new int[]{0,0,2,3};
        for (int i : twoSum(num, 0)) {
            System.out.println(i);
        }
    }



    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0){
            throw new IllegalArgumentException("");
        }
        int i = 0, j = numbers.length-1;
        while (i<j){
            if (target > numbers[i] + numbers[j]){
                i++;
            }
            if (target < numbers[i] + numbers[j]){
                j--;
            }
            if (target == numbers[i] + numbers[j]){
                return new int[]{i+1,j+1};
            }
        }
        throw new IllegalArgumentException("");
    }
}