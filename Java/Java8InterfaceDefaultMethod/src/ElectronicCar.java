public class ElectronicCar implements CarInterface {
    @Override
    public void drive() {
        System.out.println(":: Drive electronic car.");
    }

    @Override
    public void reFuel() {
        // call interface's default method.
        this.recharge();
    }
}
