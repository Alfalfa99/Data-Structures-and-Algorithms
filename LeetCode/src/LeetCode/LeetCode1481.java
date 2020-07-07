package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1481 {
    public static void main(String[] args) {

    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();//map来存储每个数字的次数
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);//map的这个用法经常用到，getOrDefault
        }
        int size = map.size();
        int[] cnt = new int[size];
        int m = 0;
        // 用keySet把每一个key取出来，然后用map.get(key)来取值
        // 之前用Map.Entry方法，感觉更繁琐
        for(int key : map.keySet()){
            cnt[m++] = map.get(key);
        }
        Arrays.sort(cnt);
        // 排序之后，从小到大，如果k大于这个数字次数，那么这个数字就可以移除
        // 否则就break
        for(int c : cnt){
            if(k >= c){
                k -= c;
                size--;
            }else{
                break;
            }
        }
        return size;
    }
}
