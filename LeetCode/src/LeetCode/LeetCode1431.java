package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1431 {
    public static void main(String[] args) {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int MaxCandi = 0;
        for(int i = 0; i < candies.length; i++){
            if(MaxCandi < candies[i]){
                MaxCandi = candies[i];
            }
        }
        List<Boolean> list = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            if(MaxCandi <= candies[i] + extraCandies){
                list.add(i,true);
            } else{
                list.add(i,false);
            }
        }
        return list;
    }
}
