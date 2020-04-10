public class LeetCode171 {
    public static void main(String[] args){
        System.out.println(titleToNumber("ZY"));
    }



    public static int titleToNumber(String s) {
        if (s == null || s == ""){
            return -1;
        }
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total = s.charAt(i) - 64 + total*26;
        }
        return total;
    }
}