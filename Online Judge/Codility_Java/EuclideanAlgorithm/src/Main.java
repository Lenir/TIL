public class Main {
    public static void main(String[] args){
        System.out.println(":: Euclidean algorithm lesson");

        int N = 4;
        int m = 2;
        ChocolatesByNumbers c = new ChocolatesByNumbers(N, m);
        System.out.println(c.getChocolates());
    }
}
