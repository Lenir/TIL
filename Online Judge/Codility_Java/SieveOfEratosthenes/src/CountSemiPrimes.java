
/*
    END, 100%
 */

import java.util.ArrayList;
import java.util.Arrays;

public class CountSemiPrimes {
    CountSemiPrimes(int N, int[] starts, int[] ends){
        this.N = N;
        this.starts = starts;
        this.ends = ends;
        primes = new ArrayList<>();
        semiPrimes = new ArrayList<>();
        semiprimeNums = new int[N+1];
        Arrays.fill(semiprimeNums, 0);
        sievePrimes();
    }

    void sievePrimes(){
        if(this.N == 1){
        }else{
            int[] sieve = new int[(N/2)+1];
            // add numbers.
            for(int i = 0; i < (N / 2)+1; i++){
                sieve[i] = i;
            }
            sieve[1] = 0;

            // sieve primes.

            for(int i = 2; i < sieve.length; i++){
                int multiple = i;
                while(i * multiple < sieve.length) {
                    sieve[i * multiple] = 0;
                    multiple += 1;
                }
            }

            // get primes
            for(int prime : sieve){
                if(prime > 0){
                    primes.add(prime);
                }
            }

            // get semi Primes

            for(int index = 0; index < primes.size(); index++){
                for(int multiple = index; multiple < primes.size(); multiple++){
                    int semiPrime = primes.get(index) * primes.get(multiple);
                    if(semiPrime <= N){
                        semiPrimes.add(semiPrime);
                    }else{
                        break;
                    }
                }
            }
            semiPrimes.sort(null);

            int num = 0;
            int index = 0;
            for(int semiprime: semiPrimes){
                while(index < semiprime){
                    semiprimeNums[index] = num;
                    index += 1;
                }
                num += 1;
            }
            while(index < semiprimeNums.length){
                semiprimeNums[index] = num;
                index += 1;
            }
        }


    }

    int[] getSemiprimeNums(){
        if(N == 1){
            int[] zeros = new int[starts.length];
            Arrays.fill(zeros, 0);
            return zeros;
        }
        int[] answer = new int[starts.length];
        for(int index = 0; index < starts.length; index++){
            int start = starts[index];
            int end = ends[index];
            answer[index] = semiprimeNums[end] - semiprimeNums[start-1];
        }
        return answer;
    }



    int N;
    int[] starts;
    int[] ends;
    int[] semiprimeNums;
    ArrayList<Integer> primes;
    ArrayList<Integer> semiPrimes;
}
