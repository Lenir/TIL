public class Main {
    public static void main(String[] args){
        int[] input = new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};

        FibFrog fibFrog = new FibFrog();
        System.out.println(fibFrog.getLeapCount(input));

    }
}
