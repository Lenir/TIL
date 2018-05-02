public class Main {
    public static void main(String[] args){
        GasolineCar gasolineCar = new GasolineCar();
        DieselCar dieselCar = new DieselCar();
        ElectronicCar electronicCar = new ElectronicCar();

        gasolineCar.drive();
        dieselCar.drive();
        electronicCar.drive();

        gasolineCar.reFuel();
        dieselCar.reFuel();
        electronicCar.reFuel();
    }
}
