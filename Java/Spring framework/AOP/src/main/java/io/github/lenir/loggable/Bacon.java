package io.github.lenir.loggable;

public class Bacon {
    Bacon(int num){
        baconNum = num;
        lyrics = "BACON";
    }

    public void baconSong(){
        for(int i = 0; i < baconNum-1; i++){
            System.out.print(lyrics + ", ");
        }
        System.out.println("Lovely " + lyrics + "!" + " Wonderful " + lyrics +"!");
    }

    int baconNum;
    String lyrics;
}
