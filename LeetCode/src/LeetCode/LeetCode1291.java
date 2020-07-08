package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 15423
 */
public class LeetCode1291 {
    public static void main(String[] args) {

    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            int num = i;
            for(int j = i+1;j <= 9; j++){
                num = num*10+j;
                if(num>=high){
                    break;
                }
                if(num>= low && num<= high){
                    res.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
