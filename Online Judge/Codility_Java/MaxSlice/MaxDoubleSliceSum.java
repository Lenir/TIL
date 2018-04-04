import java.util.*;

public class MaxDoubleSliceSum {
    MaxDoubleSliceSum(int[] input) {
        doubleMaxSliceSum = computeDoubleMaxSliceSum(input);
    }

    int computeDoubleMaxSliceSum(int[] input){

        int[] maxEndArray = new int[input.length];
        int[] maxStartArray = new int[input.length];
        int maxSumEndpoint = 0;
        int endpoint = 0;
        int maxSumStartPoint = 0;
        int startpoint = 0;

        int maxSumDoubleSlice = 0;
        for(int y = 1; y < input.length -1; y++){
            endpoint = Math.max(0, endpoint + input[y]);
//            maxSumEndpoint = Math.max(maxSumEndpoint, endpoint);
            maxEndArray[y] = endpoint;
        }

        for(int y = input.length-2; y > 0; y--){
            startpoint = Math.max(0, startpoint + input[y]);
//            maxSumStartPoint = Math.max(maxSumStartPoint, startpoint);
            maxStartArray[y] = startpoint;
        }

        for(int i = 0; i < input.length-2; i++ ){
            maxSumDoubleSlice = Math.max(maxSumDoubleSlice, maxEndArray[i] + maxStartArray[i+2]);
//            System.out.println("cur Max : " + maxSumDoubleSlice + " maxEnd : " + maxEndArray.get(i) + " maxStart : " + maxStartArray.get(i));
        }
        return maxSumDoubleSlice;
    }

    int getDoubleMaxSliceSum(){
        return doubleMaxSliceSum;
    }

    int doubleMaxSliceSum;
}
