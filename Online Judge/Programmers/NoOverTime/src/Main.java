public class Main {
    public static void main(String[] args) {
        int []test = {4,3,3};
        NoOvertime c = new NoOvertime(4, test);
        System.out.println(c.minWork);
        System.out.println(c.isGoingLowerThanMinWork());
        System.out.println(c.additionalWork);
        System.out.println(c.noOvertime());
    }
}
