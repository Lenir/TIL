
public class ChocolatesByNumbers {
    ChocolatesByNumbers(int N, int m){
        this.N = N;
        this.m = m;
    }

    int euclideanAlgorithm(){
        int a = N;
        int b = m;
        int gcd = 1;

        while(a != b && a > 0 && b > 0){
            if(a >= b){
                a = a % b;
                if(a == 0){
                    return b;
                }
                b = b % a;
            }else{
                b = b % a;
                if(b == 0){
                    return a;
                }
                a = a % b;
            }
            gcd = Math.max(a, b);
        }
        return gcd;
    }

    int getChocolates(){
        return N / euclideanAlgorithm();
    }

    int N;
    int m;

}
