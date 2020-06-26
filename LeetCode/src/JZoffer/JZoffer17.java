package JZoffer;

public class JZoffer17 {
    public static void main(String[] args) {
    }

    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10, n);
        int[] arr = new int[num - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
