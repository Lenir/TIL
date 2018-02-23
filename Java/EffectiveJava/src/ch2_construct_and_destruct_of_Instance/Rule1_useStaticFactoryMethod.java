package ch2_construct_and_destruct_of_Instance;

class Spam{
    private int spamNum;
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
}

public class Rule1_useStaticFactoryMethod {
    public static void main(){
        // default constructor
        Spam spam = new Spam(1);
        // static factory method - more readability!
        SpamWithFactory spamWithFactory = SpamWithFactory.produceSpams(5);
        System.out.println(spam.getMultipleSpams());
        System.out.println(spamWithFactory.getMultipleSpams());
    }
}
