/*
    END, 100%
 */
import java.util.*;

public class EquiLeader {
    EquiLeader(int[] input){
        integerStack = new Stack<Integer>();
        try{
            getLeader(input);
            equiLeaderSize = getEquiLeader(input);
        }catch (Exception e){}

    }

    void getLeader(int[] input) throws Exception{
        if(input.length == 0){
            throw new Exception("Empty input array excepion");
        }else {
            int candidate = input[0];
            for(int i = 0; i < input.length; i++){
                if (integerStack.isEmpty()) {
                    candidate = input[i];
                    integerStack.push(candidate);
                }else{
                    int curValue = input[i];
                    if(curValue == candidate){
                        integerStack.push(curValue);
                    }else{
                        integerStack.pop();
                    }
                }
            }

            leaderSize = 0;
            for(int i = 0; i < input.length; i++){
                if(input[i] == candidate){
                    leaderSize += 1;
                }
            }
            leader = candidate;
        }
    }

    int getEquiLeader(int[] input){
        int equiLeaderSize = 0;
        int formerLeaderSize = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] == leader){
                formerLeaderSize += 1;
            }

            if(isEquiLeader(input.length, formerLeaderSize, i)){
                equiLeaderSize += 1;
            }
        }
        return equiLeaderSize;

    }

    Boolean isEquiLeader(int totalSize, int formerLeaderSize, int currentIndex){
        int latterSize = totalSize - (currentIndex + 1);

        int latterLeaderSize = leaderSize - formerLeaderSize;
        int formerNonLeaderSize = (currentIndex + 1) - formerLeaderSize;
        int latterNonLeaderSize = latterSize - latterLeaderSize;

        return (formerLeaderSize > formerNonLeaderSize && latterLeaderSize > latterNonLeaderSize);
    }

    int getEquiLeaderSize(){
        return equiLeaderSize;
    }


    int leader;
    int leaderSize;
    int equiLeaderSize;
    Stack<Integer> integerStack;
}
