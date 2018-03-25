/*
    END, 100%
 */
import java.util.*;

public class Nesting {
    Nesting(String input){
        charStack = new Stack<Character>();

        try{
            pushCharacters(input);
        }catch (Exception e){

        }
    }

    void pushCharacters(String inputString) throws Exception{
        for(int i = 0; i < inputString.length(); i++){
            Character pushingChar = inputString.charAt(i);
            if(pushingChar.equals('(')){
                charStack.push(pushingChar);
            }else{
                if(charStack.isEmpty()){
                    charStack.push(pushingChar);
                    throw new Exception("Not Properly Nested");
                }else{
                    charStack.pop();
                }
            }
        }
    }

    Boolean isProperlyNested(){
        if(charStack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    Stack<Character> charStack;
}
