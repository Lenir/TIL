/*
    END, 100%
 */

public class CountFactors {
    CountFactors(int N){
        this.N = N;
    }

    int getFactorsNum(){
        int factors = 0;
        for(int i = 1; i < Math.ceil(Math.sqrt(N)); i++){
            if(N % i == 0){
                factors += 2;
            }
        }
        if(Math.sqrt(N) == Math.ceil(Math.sqrt(N))){
            factors += 1;
        }
        return factors;
    }

    int N;
}
