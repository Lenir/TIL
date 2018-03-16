/*
    END, 100%
 */

import java.util.Arrays;

public class MaxProductOfThree {
    MaxProductOfThree(int[] input){
        element = input;
        Arrays.sort(element);
    }

    int getMax3Product(){
        int lastIndex = element.length - 1;
        int result = element[lastIndex] * element[lastIndex - 1] * element[lastIndex - 2];
        return result;
    }

    int getMin2Max1Product(){
        int lastIndex = element.length - 1;
        int result = element[lastIndex] * element[1] * element[0];
        return result;
    }

    int getMaxProductOfThree(){
        int max3Product = getMax3Product();
        int max2Min1Product = getMin2Max1Product();
        return Math.max(max3Product, max2Min1Product);
    }

    private int[] element;
}
