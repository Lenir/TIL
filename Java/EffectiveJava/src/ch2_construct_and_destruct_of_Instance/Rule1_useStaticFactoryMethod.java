package ch2_construct_and_destruct_of_Instance;
import java.util.*;

class Spam{
    private int spamNum;
    Spam(){
        spamNum = 0;
    }
    Spam(int _spamNum) {
        spamNum = _spamNum;
    }

    public String getMultipleSpams(){
        String result = "";
        for(int i = 0; i < spamNum; i++){
            result += "Spam";
        }
        return result;
    }
}

class SpamChild extends Spam{
    private int childSpamNum;
    SpamChild(){
        childSpamNum = 0;
    }

    SpamChild(int _childSpamNum){
        childSpamNum = _childSpamNum;
    }
}

class SpamWithFactory{
    private int spamNum;
    SpamWithFactory(int _spamNum) {
        spamNum = _spamNum;
    }


    public static SpamWithFactory produceSpams(int _spamNum){
        SpamWithFactory spam = new SpamWithFactory(_spamNum);
        return spam;
    }

    public String getMultipleSpams(){
        String result = "";
        for(int i = 0; i < spamNum; i++){
            result += "Spam ";
        }
        return result;
    }

    public static <K, V> HashMap<K, V> newHashMap(){
        return new HashMap<K, V>();
    }

}

//class SpamWithFactoryChild extends SpamWithFactory{
//
//}

public class Rule1_useStaticFactoryMethod {
    public static void main(){
        // **** pros of static factory method ****
        // ** for readability **
        // default constructor
        Spam spam = new Spam(1);

        // static factory method - more readability!
        SpamWithFactory spamWithFactory = SpamWithFactory.produceSpams(5);
        System.out.println(spam.getMultipleSpams());
        System.out.println(spamWithFactory.getMultipleSpams());

        // ** for short code width in generic programming **
        // default constructor
        HashMap<Integer, List<String> > map = new HashMap<Integer, List<String> >();

        // static factory method - shorten code width
        HashMap<Integer, List<String> > map2 = SpamWithFactory.newHashMap();

        // **** cons of static factory method ****
        // no default constructor - cannot inherit child class
        // look commented code - SpamWithFactoryChild class
        Spam child = new SpamChild();

    }
}
