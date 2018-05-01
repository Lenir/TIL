import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FibFrog {
    FibFrog(){
    }

    int[] getFibonacciArray(int arrayLength){
        int[] result = new int[arrayLength];

        for(int index = 0; index < arrayLength; index++){
            if(index < 2){
                result[index] = index;
            }else{
                result[index] = result[index - 2] + result[index - 1];
            }
        }

        return result;
    }

    int getLeapCount(int[] leafs){
        int riverWidth = leafs.length;
        ArrayList<Integer> leafIndexes = getLeafIndexes(leafs);
        Collections.reverse(leafIndexes);
        int leaps = 0;
        int curLocation = -1;
        int[] fibonacciArray = getFibonacciArray(leafs.length);

        int firstLeapIndex = riverWidth - 1;
        while(curLocation < riverWidth){
            if(Arrays.binarySearch(fibonacciArray, riverWidth - curLocation) >= 0){
                return leaps + 1;
            }else{
                for(int leafIndex : leafIndexes){
                    int leapDistance = Arrays.binarySearch(fibonacciArray, leafIndex - curLocation);

                    if(leapDistance >= 0){
//                        System.out.println("leaf Index : " + leafIndex + " leapDistance : " + fibonacciArray[leapDistance]);
                        leaps += 1;
                        curLocation += fibonacciArray[leapDistance];
                        break;
                    }
                }
            }

        }

        return leaps;
    }

    ArrayList<Integer> getLeafIndexes(int[] leafs){
        ArrayList<Integer> leafIndexes = new ArrayList<>();
        for(int index = 0; index < leafs.length; index++){
            if(leafs[index] == 1){
                leafIndexes.add(index);
            }
        }

        return leafIndexes;
    }

    Boolean isLeafExists(int[] leafs, int index){
        if(index >= leafs.length || index < 0){
            return Boolean.FALSE;
        }else{
            return leafs[index] == 1;
        }
    }


}
