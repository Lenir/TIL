/*
    END, 100%
 */

import java.util.*;
public class Dominator {
    Dominator(int[] input){
        dominatorStack = new Stack<Integer>();
        searchDominator(input);
    }

    void searchDominator(int[] inputArray){
        if(inputArray.length == 0){
            dominatorIndex = -1;
            return;
        }else {
            int dominatorCandidate = inputArray[0];

            for (int i = 0; i < inputArray.length; i++) {
                int targetValue = inputArray[i];
                if (dominatorStack.isEmpty()) {
                    // new Candidate
                    dominatorCandidate = targetValue;
                    dominatorStack.push(targetValue);
                    dominatorIndex = i;
                } else {
                    // pop or push
                    if (targetValue == dominatorStack.lastElement()) {
                        dominatorStack.push(targetValue);
                    } else {
                        dominatorStack.pop();
                    }
                }
            }

            int candidateSize = 0;
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] == dominatorCandidate) {
                    candidateSize += 1;
                }
            }

            if (candidateSize <= (inputArray.length) / 2) {
                dominatorIndex = -1;
            }
        }

    }

    int getDominatorIndex(){
        return dominatorIndex;
    }

    int dominatorIndex;
    Stack<Integer> dominatorStack;
}
