import java.util.HashMap;

public class LeetCode13 {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;
        if (chars.length == 1){
            total+=map.get(chars[0]);
            return total;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i+1>=chars.length) {
                total+=map.get(chars[i]);
                break;
            }
            if (map.get(chars[i]) < map.get(chars[i+1])) {
                total += map.get(chars[i + 1]) - map.get(chars[i]);
                i++;
            } else {
                total += map.get(chars[i]);
            }
        }
        if (total > 3999 && total < 1){
            throw new IllegalArgumentException();
        }
        return total;
    }
}
