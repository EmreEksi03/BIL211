package Inheritance.AbstractClassExercise;

public class Pigeon extends Bird{
    Pigeon(String name) {
        super(name);
    }
    String voice = "bawwk";
    int flapsPer100m = 20;
    @Override
    void speak() {
        System.out.println(voice);
    }

    @Override
    void displayFlaps() {
        System.out.println("This bird flaps " + flapsPer100m +  " times in 100 m flight.");
    }
}
