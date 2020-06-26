package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public static void main(String[] args) {
        System.out.println(minWindow("a","b"));
    }

    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        //  ascii('z') = 122
        //  winFreq : 当前滑动窗口中各个字符出现的次数
        int[] winFreq = new int[128];
        //  tFreq : 目标字符串T中各个字符出现的次数
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }
        // 目前滑动窗口中包含多少个T中的字符,对应字符出现的次数如果大于T中出现的次数则不计入
        int distance = 0;
        //  当前滑动窗口的左右边界
        int left = 0, right = 0;
        // 当前最短滑动窗口的左边界和其长度
        int begin = 0, minLen = sLen + 1;
        while (right < sLen){
            char charRight = charArrayS[right];
            //如果当前字符(charRight)不在T中则直接将右边界右移
            if (tFreq[charRight] == 0){
                right++;
                continue;
            }
            //如果当前字符在T字符串中且出现的次数没有超过希望的次数时,distance++
            if (winFreq[charRight] < tFreq[charRight]){
                distance++;
            }
            //当前滑动窗口中多了一个字符
            winFreq[charRight]++;
            //右边界右移
            right++;

            //  如果distance == tLen,则说明当前滑动窗口中已经存在了所有T中的字符,T中字符是S中字符的子集
            while (distance == tLen){
                //  如果当前的最小长度比记录中的最小长度还要小,则更新记录
                if (minLen > right - left){
                    minLen = right-left;
                    //  更新最小窗口的左边界
                    begin = left;
                }
                char charLeft = charArrayS[left];
                //如果当前字符不在T中,直接抛弃该字符,并且左边界右移
                if (tFreq[charLeft] == 0){
                    left++;
                    continue;
                }
                //如果当前字符在滑动窗口中出现的次数和在T中出现的次数相同则说明,当前的滑动窗口已经是包含T的最小滑动窗口,
                //left再往右移一步的时候T中字符就不是S中字符的子集了.
                if (tFreq[charLeft] == winFreq[charLeft]){
                    //当前滑动窗口中的包含的T中的字符数-1,执行完该语句会跳出循环,因为distance!=tLen
                    distance--;
                }
                //当前活动窗口中该字符出现的次数-1
                winFreq[charLeft]--;
                //左边界右移
                left++;
            }
        }
        //如果minLen == sLen+1,说明根本没有任何可能使得T中字符是S中字符的子集,返回空串
        if (minLen == sLen+1){
            return "";
        }
        //返回修剪过后的字符串
        return s.substring(begin,begin+minLen);
    }
}
