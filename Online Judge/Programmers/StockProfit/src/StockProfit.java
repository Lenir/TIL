import java.util.ArrayList;
import java.util.Arrays;

public class StockProfit {
    StockProfit(int[] prices){
        priceDiff = computePriceDiff(prices);
        priceDiffPrefixSum = computePriceDiffPrefixSum();
    }

    int[] computePriceDiff(int[] prices){
        int[] result = new int[prices.length];
        result[0] = 0;

        for(int index = 1; index < result.length; index++){
            result[index] = prices[index] - prices[index-1];
        }

        return result;
    }

    int[] computePriceDiffPrefixSum(){
        int[] result = new int[priceDiff.length];
        int sum = 0;
        for(int index = 0; index < result.length; index++){
            sum += priceDiff[index];
            result[index] = sum;
        }

        return result;
    }

    int[] computeDayForProfit(){
        int[] result = new int[priceDiff.length];
        Arrays.fill(result, -1);
        ArrayList<Integer> computeQueue = new ArrayList<>();

        for(int index = 0; index < result.length; index++){
            computeQueue.add(index);
            for(int queueIndex = computeQueue.size() -1 ; queueIndex >= 0; queueIndex--){
                int stockBuyIndex = computeQueue.get(queueIndex);
                // not compute yet or cannot get profit
                if(priceDiffPrefixSum[index] - priceDiffPrefixSum[stockBuyIndex] > 0){
                    result[stockBuyIndex] = index - stockBuyIndex;
                    computeQueue.remove(queueIndex);
                }
            }
        }

        return result;
    }

    int[] priceDiff;
    int[] priceDiffPrefixSum;
}
