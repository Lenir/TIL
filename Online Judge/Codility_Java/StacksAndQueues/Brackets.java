/*
    END, 100%
 */

import java.util.*;

public class Brackets {
    Brackets(String input){
        bracketStack = new Stack<Character>();
        isProperlyNested = parseBracketString(input);
    }

    Boolean parseBracketString(String inputString){
        for(int i = 0; i < inputString.length(); i++){
            Character bracket = inputString.charAt(i);
            if(isEnclosingBracket(bracket)){
                if(isTopMatchesWithOpeningBracket(bracket)){
                    popOpeningBracket();
                }else{
                    return false;
                }
            }else{
                pushOpeningBracket(bracket);
            }
        }

        if(bracketStack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    void pushOpeningBracket(Character bracket){
        bracketStack.push(bracket);
    }

    Boolean isTopMatchesWithOpeningBracket(Character enclosingBracket){
        if(bracketStack.isEmpty()){
            return false;
        }else if(enclosingBracket.equals(')')){
            return bracketStack.lastElement().equals('(');
        }else if(enclosingBracket.equals('}')){
            return bracketStack.lastElement().equals('{');
        }else{
            return bracketStack.lastElement().equals('[');
        }
    }

    Character popOpeningBracket(){
        return bracketStack.pop();
    }

    Boolean isEnclosingBracket(Character bracket){
        return (bracket.equals(')') || bracket.equals('}') || bracket.equals(']'));
    }

    Boolean isProperlyNested(){
        return isProperlyNested;
    }

    Stack<Character> bracketStack;
    Boolean isProperlyNested;
}
