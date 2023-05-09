package activities;

public class Car {
    String color;
    String transmission;
    int tyres;
    int doors;
    int make;

    public Car() {
        tyres = 4;
        doors= 4;
    }
    public void displayCharacteristics(){
        System.out.println("Color of the car is"+ color);
        System.out.println("making year of the car is"+ make);
        System.out.println("total door of the car are "+ tyres);
        System.out.println("total tyre of the car are "+ doors);
        System.out.println("transmission type of the car is"+ transmission);
    }

    public void accelerate() {
        System.out.println("Car is moving the forward");
    }

    public void brake() {
        System.out.println("Car has stopped");
    }
}
