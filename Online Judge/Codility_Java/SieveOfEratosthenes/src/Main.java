public class Main {
    public static void main(String[] args){
        System.out.println("houdy!");

        CountSemiPrimes countSemiPrimes = new CountSemiPrimes(1, new int[]{1}, new int[]{1});
        System.out.println(countSemiPrimes.primes);
        System.out.println(countSemiPrimes.semiPrimes);
        System.out.println(countSemiPrimes.getSemiprimeNums()[0]);
    }
}
