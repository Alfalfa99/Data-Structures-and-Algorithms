import java.util.ArrayList;
import java.util.List;

public class JZoffer64 {
    public static void main(String[] args) {

    }

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
