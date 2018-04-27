public class Main {
    public static void main(String[] args){
        int[] input = new int[]{10, 7, 6, 7, 8, 11, 9};
        StockProfit stockProfit = new StockProfit(input);
        int[] result = stockProfit.computeDayForProfit();

        for(int answer : result){
            System.out.print(answer + ", ");
        }
    }
}
