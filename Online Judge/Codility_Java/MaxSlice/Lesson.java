import java.util.*;

public class Lesson {
    Lesson(int[] intArray){
        this.input = intArray;
    }

    void computeMaxSlice_nCube(){
        int maxSumCandidate = input[0];
        int maxSliceStartCandidate = 0;
        int maxSliceEndCandidate = 0;
        for(int startIndex = 0; startIndex < input.length; startIndex++){
            // move start index
            for(int endIndex = startIndex; endIndex < input.length; endIndex++ ){
                // move end index;
                int localSum = 0;
                for(int sumIndex = startIndex; sumIndex <= endIndex; sumIndex++ ){
                    // get local sum
                    localSum += input[sumIndex];
                }
                if(localSum > maxSumCandidate){
                    maxSumCandidate = localSum;
                    maxSliceStartCandidate = startIndex;
                    maxSliceEndCandidate = endIndex;
                }
            }
        }

        maxSliceSum = maxSumCandidate;
        maxSliceStart = maxSliceStartCandidate;
        maxSliceEnd = maxSliceEndCandidate;
    }

    void computeMaxSlice_nSquare(){
        // use prefix sum
        ArrayList<Integer> prefixSum = new ArrayList<Integer>();
        int sum = 0;
        for(int prefixSumIndex = 0; prefixSumIndex < input.length; prefixSumIndex++){
            // build prefix sum array
            sum += input[prefixSumIndex];
            prefixSum.add(sum);
        }

        int localMaxSum = 0;
        int maxSliceStartCandidate = 0;
        int maxSliceEndCandidate = 0;
        for(int startIndex = 0; startIndex < input.length; startIndex++){
            // move start index
            for(int endIndex = startIndex; endIndex < input.length-1; endIndex++ ){
                // move end index;
                int localSum = prefixSum.get(endIndex + 1) - prefixSum.get(startIndex);
                if(localSum > localMaxSum){
                    localMaxSum = localSum;
                    maxSliceStartCandidate = startIndex+1;
                    maxSliceEndCandidate = endIndex+1;
                }
            }
        }

        maxSliceSum = localMaxSum;
        maxSliceStart = maxSliceStartCandidate;
        maxSliceEnd = maxSliceEndCandidate;

    }

    void computeMaxSlice_n(){
        int sliceSumEndpoint = 0;
        int localMaxSum = 0;

        Boolean isStartCandidateSet = false;
        int maxSliceStartCandidate = 0;
        int maxSliceEndCandidate = 0;
        for(int index = 0; index < input.length; index++){
            if(0 < sliceSumEndpoint + input[index]){
                sliceSumEndpoint += input[index];
                if(!isStartCandidateSet){
                    maxSliceStartCandidate = index;
                    isStartCandidateSet = true;
                }
            }else{
                sliceSumEndpoint = 0;
                isStartCandidateSet = false;
            }
            if(localMaxSum < sliceSumEndpoint){
                localMaxSum = sliceSumEndpoint;
                maxSliceEndCandidate = index;
            }
        }

        maxSliceSum = localMaxSum;
        maxSliceStart = maxSliceStartCandidate;
        maxSliceEnd = maxSliceEndCandidate;
    }

    void printMaxSlice(){
        System.out.println("Max Sum : " + maxSliceSum + " starts " + maxSliceStart + " ends " + maxSliceEnd);

    }

    int maxSliceSum;
    int maxSliceStart;
    int maxSliceEnd;
    int[] input;
}
