/*
    END, 100%
 */

public class MaxProfit {
    MaxProfit(int[] stockPrices){
        maxProfit = computeMaxProfit(stockPrices);
    }

    int computeMaxProfit(int[] stockPrices){
        int maxProfit = 0;
        int localMaxProfit = 0;
        int[] priceChange = new int[stockPrices.length];

        for(int i = 0; i < stockPrices.length; i++){
            if(i == 0){
                priceChange[i] = 0;
            }else{
                priceChange[i] = stockPrices[i] - stockPrices[i-1];
            }

        }

        for(int i = 0; i < priceChange.length; i++){
            localMaxProfit = Math.max(0, localMaxProfit + priceChange[i]);
            maxProfit = Math.max(maxProfit, localMaxProfit);
        }
        return maxProfit;
    }

    int getMaxProfit(){
        return maxProfit;
    }

    int maxProfit;
}
