package LeetCode;

public class LeetCode278 {
    public static void main(String[] args) {

    }

    /**
     * 题目提供的类,这里不具体实现
     */
    public class VersionControl{
        boolean isBadVersion(int mid) {
            return true;
        }
    }
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1, right = n;
            while(left < right){
                //避免(left + right)/2 过大时发生溢出
                int mid = left + (right - left )/2;
                if(isBadVersion(mid)){
                    right = mid;
                } else{
                    left = mid+1;
                }
            }
            return left;
        }
    }
}
