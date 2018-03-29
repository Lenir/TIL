/*
    END, 100%
 */

public class MaxSliceSum {
    MaxSliceSum(int[] input){
        maxSliceSum = computeMaxSliceSum(input);
    }

    int computeMaxSliceSum(int[] input){
        int maxSumEndsHere;
        int maxSliceSum;
        Boolean isAllMinus = true;

        for(int i = 1; i < input.length; i++){
            if(isAllMinus){
                isAllMinus = (input[i] < 0);
            }else{
                break;
            }
        }

        if(isAllMinus){
            maxSumEndsHere = input[0];
            maxSliceSum = input[0];
            for(int i = 1; i < input.length; i++){
                maxSumEndsHere = Math.max(input[i], maxSumEndsHere + input[i]);
                maxSliceSum = Math.max(maxSumEndsHere, maxSliceSum);
            }
        }else{
            maxSumEndsHere = 0;
            maxSliceSum = 0;
            for(int i = 0; i < input.length; i++){
                maxSumEndsHere = Math.max(0, maxSumEndsHere + input[i]);
                maxSliceSum = Math.max(maxSumEndsHere, maxSliceSum);
            }
        }


        return maxSliceSum;
    }

    int getMaxSliceSum(){
        return maxSliceSum;
    }

    int maxSliceSum;
}
