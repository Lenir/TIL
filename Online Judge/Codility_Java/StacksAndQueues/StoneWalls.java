/*
    END, 100%
 */

import java.util.*;

public class StoneWalls {
    StoneWalls(int[] input){
        blocks = 0;
        heightStack = new Stack<Integer>();
        buildHeightStack(input);
        popLastingHeights();
    }

    void buildHeightStack(int[] inputHeights){
        for(int height : inputHeights){
            pushHeight(height);
//            System.out.println(heightStack);
        }
    }

    void pushHeight(int height){
        if(heightStack.isEmpty()){
//            System.out.println("push" + height);
            heightStack.push(height);
        }else{
            int topHeight = heightStack.lastElement();
            if(topHeight <= height){
                // new height is higher than or equals with top item.
//                System.out.println("push" + height);
                heightStack.push(height);
            }else{
                // new height is lower than top item.
                while(topHeight > height){
                    popEquals();
                    if(heightStack.isEmpty()){
                        break;
                    }
                    topHeight = heightStack.lastElement();
                }
//                System.out.println("push" + height);
                heightStack.push(height);
            }
        }
    }

    void popLastingHeights(){
        while(!heightStack.isEmpty()){
            popEquals();
        }
    }

    int popEquals(){
        int popElement = heightStack.pop();
//        System.out.println("pop" + popElement);
        while(!heightStack.isEmpty() && popElement == heightStack.lastElement()){
            heightStack.pop();
        }
        blocks+=1;
        return popElement;
    }

    int getBlocks(){
        return blocks;
    }

    Stack<Integer> heightStack;
    int blocks;
}
