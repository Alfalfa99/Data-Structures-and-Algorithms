package LeetCode;


import java.util.HashMap;

public class LeetCode290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        Solution solution = new Solution();
        System.out.println(solution.wordPattern(pattern,str));
    }

    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            HashMap<Character,String> map = new HashMap<>();
            String[] ss = s.split(" ");
            if (ss.length != pattern.length()){
                return false;
            }
            for(int i = 0; i < ss.length; i++){
                char c = pattern.charAt(i);
                if(map.containsKey(c)){
                    if(map.get(c).equals(ss[i])){
                        continue;
                    } else{
                        return false;
                    }
                } else{
                    if (map.containsValue(ss[i])){
                        return false;
                    }
                    map.put(c, ss[i]);
                }
            }
            return true;
        }
    }
}

