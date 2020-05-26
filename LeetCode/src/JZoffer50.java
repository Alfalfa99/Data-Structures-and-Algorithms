public class JZoffer50 {
    public static void main(String[] args) {

    }

    public static char firstUniqChar(String s) {
        if (s.equals("")){
            return ' ';
        }
        //char 只有256个字符,开个256数组即可全部存完
        int[] hash = new int[256];
        char[] chars = s.toCharArray();
        //把字符串中各个字符出现的次数存到hash中
        for (char c : chars) {
            hash[c]++;
        }
        for (char c : chars) {
            //寻找出现次数为1的数
            if (hash[c] == 1){
                return c;
            }
        }
        return ' ';
    }
}