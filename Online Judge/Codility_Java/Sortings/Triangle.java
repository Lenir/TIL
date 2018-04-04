import com.sun.deploy.util.ArrayUtil;

/*
    END : 100%
 */

import java.util.*;

public class Triangle {

    Triangle(int[] input){
        sortedList = input;
        Arrays.sort(sortedList);
    }

    boolean isTriangular(){
        for(int i = 0; i < sortedList.length - 2; i++){
            int P = sortedList[i];
            int Q = sortedList[i+1];
            int R = sortedList[i+2];
            int sum = P + Q + R;
            if((sum > 2*P) && (sum > 2*Q) && (sum > 2*R)){
                return true;
            }
        }
        return false;
    }
    private int[] sortedList;
}

