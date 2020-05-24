public class JZoffer48 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaaa"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        if (sLen <= 1){
            return sLen;
        }
        //将s转成字符数组方便后边取值
        char[] charArrayS = s.toCharArray();
        //winFreq : 当前滑动窗口中各个字符出现的次数
        int[] winFreq = new int[128];
        //[left,right)
        int left = 0, right = 0;
        //最大长度设置为0
        int maxLen = 0;
        while (right < sLen){
            //取出当前的滑动窗口最右边的字符
            char charRight = charArrayS[right];
            //当前字符在滑动窗口中出现的次数+1;
            winFreq[charRight]++;
            //右边界右移
            right++;
            //如果当前字符在当前滑动窗口中出现的次数>1,则需要将当前字符左边的相同字符去掉
            while (winFreq[charRight] > 1){
                //获得当前滑动窗口的左边字符
                char charLeft = charArrayS[left];
                //找到与当前字符相同的左边字符
                if (charLeft == charRight){
                    //当前字符在滑动窗口中出现的次数-1
                    winFreq[charLeft]--;
                    //否则将左边界字符出现的次数归零,不归零会出现问题如 s = "tmmxuwat"时,左边第一个t没有被归零,只会截取xuwa
                } else {
                    winFreq[charLeft] = 0;
                }
                //左边界右移
                left++;
            }
            //去重完毕后查看本次滑窗中是否为最长子串
            if (right - left > maxLen){
                maxLen = right - left;
            }
        }
        return maxLen;
    }
}