/*
    END, 100%
 */

import java.util.Arrays;

public class Distinct {
    Distinct(int[] input){
        element = input;
        Arrays.sort(element);
    }

    int getDistinctElementNum(){
        if(element.length == 0){ // when empty
            return 0;
        }

        int pastElement = element[0];
        int result = 1;
        for(int i = 1; i < element.length; i++){
            if(element[i] != pastElement){
                result += 1;
                pastElement = element[i];
            }
        }
        return result;
    }

    private int[] element;
}
