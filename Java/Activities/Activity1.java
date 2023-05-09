package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car Car1 = new Car();
        Car1.make = 2014;
        Car1.color = "Black";
        Car1.transmission = "manual";

        Car1.displayCharacteristics();
        Car1.accelerate();
        Car1.brake();
    }
}
