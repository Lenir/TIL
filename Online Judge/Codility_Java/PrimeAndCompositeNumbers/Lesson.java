import java.util.*;

public class Lesson {
    Lesson(int target){
        this.target = target;
    }

    Boolean isPrime_PrimarityTest(){
        if(target == 1){
            return true;
        }else{
            for(int i = 2; i <= Math.ceil(Math.sqrt(target)); i++){
                if(target % i == 0){
                    return false;
                }
            }
        }
        return true;
    }

    ArrayList<Integer> getDivisors(){
        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for(int i = 1; i <= Math.ceil(Math.sqrt(target)); i++){
            if(target % i == 0){
                divisors.add(i);
            }
        }

        if(target > 2) {
            if(Math.ceil(Math.sqrt(target)) == Math.sqrt(target)){
                for (int i = divisors.size() - 2; i >= 0; i--) {
                    divisors.add((target / divisors.get(i)));
                }
            }else{
                for (int i = divisors.size() - 1; i >= 0; i--) {
                    divisors.add((target / divisors.get(i)));
                }
            }

        }

        return divisors;
    }

    int target;
}
