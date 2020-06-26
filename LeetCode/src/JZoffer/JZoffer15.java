package JZoffer;

public class JZoffer15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }

    public static int hammingWeight(int n) {
        int  cnt = 0;
        while(n!=0){
            //统计1的个数
            cnt++;
            //消去n最右边的1
            n&=(n-1);
        }
        return cnt;
    }
}
