/*
    END, 100%
 */

import java.util.*;

class VoraciousFish{
    VoraciousFish(int size, int direction){
        this.size = size;
        this.direction = direction;
    }

    int getSize(){
        return size;
    }

    int getDirection(){
        return direction;
    }

    Boolean isUpstreamFish(){
        return (direction == 0);
    }

    Boolean isBigger(VoraciousFish fish){
        return (this.size > fish.getSize());
    }

    int size;
    int direction;
}

public class Fish {
    Fish(int[] sizes, int[] directions){
        fishStack = new Stack<VoraciousFish>();
        pushFishes(sizes, directions);
    }

    void pushFishes(int[] sizes, int[] directions){
        for(int i = 0; i < sizes.length; i++){
            VoraciousFish fish = new VoraciousFish(sizes[i], directions[i]);
            pushFish(fish);
        }
    }

    void pushFish(VoraciousFish fish){
        if(fish.isUpstreamFish()){
            // 들어온 고기가 0이면 0인 고기를 만나거나 비거나 잡아먹힐때 까지 pop
            if(fishStack.isEmpty()){
                // 비었을 경우
                fishStack.push(fish);
            }else if(isTopFishSwimsOpposite(fish)){
                // 스택의 맨 위 고기가 다른 방향의 고기일 경우
                while(isTopFishSwimsOpposite(fish) && !fishStack.isEmpty()){
                    VoraciousFish topFish = fishStack.lastElement();
                    if(fish.isBigger(topFish)){
                        fishStack.pop();
                    }else{
                        // 이 고기가 잡아먹힘
                        return;
                    }
                    if(fishStack.isEmpty()){
                        break;
                    }
                }
                fishStack.push(fish);
            }else{
                fishStack.push(fish);
            }
        }else{
            // 들어온 고기가 1이면 push
            fishStack.push(fish);
        }
    }

    Boolean isTopFishSwimsOpposite(VoraciousFish fish){
        return (fish.getDirection() != fishStack.lastElement().getDirection());
    }

    int getSurvivedFishNum(){
        return fishStack.size();
    }

    Stack<VoraciousFish> fishStack;
}
