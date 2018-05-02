public class GasolineCar implements CarInterface {
    @Override
    public void drive() {
        System.out.println(":: Drive gasoline car.");
    }

    @Override
    public void reFuel() {
        System.out.println(":: Refuel gasoline.");
    }
}
