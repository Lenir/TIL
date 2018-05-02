public interface CarInterface {
    void drive();
    void reFuel();

    // when add electronic car

    default void recharge(){
        System.out.println(":: Recharge battery.");
    }

}
