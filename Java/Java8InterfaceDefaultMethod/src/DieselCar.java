public class DieselCar implements CarInterface {
    @Override
    public void drive() {
        System.out.println(":: Drive diesel car.");
    }

    @Override
    public void reFuel() {
        System.out.println(":: Refuel diesel.");
    }
}
