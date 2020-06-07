public class JZoffer63 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int maxValue = 0;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
                continue;
            }
            if((prices[i] - min) > maxValue){
                maxValue = prices[i] - min;
            }
        }
        return maxValue;
    }
}
