package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode315 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1};
        for (Integer integer : countSmaller(nums)) {
            System.out.println(integer);
        }
    }

    private static int[] index;
    private static int[] aux;
    private static int[] counter;

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        aux = new int[len];
        counter = new int[len];
        index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        //归并排序并统计
        mergeAndCount(nums, 0, len - 1);
        //遍历获取统计结果
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }
    //归并排序入口
    private static void mergeAndCount(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeAndCount(nums, l, m);
        mergeAndCount(nums, m + 1, r);
        //检查已排序的部分
        if (nums[index[m]] > nums[index[m + 1]]) {
            sortAndCount(nums, l, m, r);
        }
    }
    //子数组排序并统计
    private static void sortAndCount(int[] nums, int l, int m, int r) {
        for(int i = l; i <= r; i++) {
            aux[i] = index[i];
        }
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                index[k] = aux[j++];
            } else if (j > r) {
                index[k] = aux[i++];
                //排序的是索引数组，仍然可以通过索引找到原来数组中的元素，并更新统计值
                //右边先走完，那么右边的都是逆序
                counter[index[k]] += (r - m);
            } else if (nums[aux[i]] <= nums[aux[j]]) {
                index[k] = aux[i++];
                //插入左边的元素时，统计已经产生的逆序部分
                counter[index[k]] += (j - m - 1);
            } else {
                index[k] = aux[j++];
            }
        }
    }
}
