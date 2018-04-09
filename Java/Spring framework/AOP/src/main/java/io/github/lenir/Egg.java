package io.github.lenir;

public class Egg {
    Egg(int num){
        eggNum = num;
        lyrics = "EGG";
    }

    void eggSong(){
        for(int i = 0; i < eggNum-1; i++){
            System.out.print(lyrics + ", ");
        }
        System.out.println("Lovely " + lyrics + "!" + " Wonderful " + lyrics +"!");
    }

    int eggNum;
    String lyrics;
}
