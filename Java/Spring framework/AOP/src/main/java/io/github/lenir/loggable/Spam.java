package io.github.lenir.loggable;

public class Spam {
    Spam(int num){
        spamNum = num;
        lyrics = "SPAM";
    }

    public void spamSong(){
        for(int i = 0; i < spamNum-1; i++){
            System.out.print(lyrics + ", ");
        }
        System.out.println("Lovely " + lyrics + "!" + " Wonderful " + lyrics +"!");
    }

    int spamNum;
    String lyrics;
}
