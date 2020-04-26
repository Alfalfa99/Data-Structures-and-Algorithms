public class JZoffer11 {

    public int minArray(int[] numbers) {
        if (numbers.length == 0){
            throw new IllegalArgumentException();
        }
        for(int i = 1; i < numbers.length; i++){
            if (numbers[i] < numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

}
