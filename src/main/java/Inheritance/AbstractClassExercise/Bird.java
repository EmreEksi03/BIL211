package Inheritance.AbstractClassExercise;

abstract public class Bird {
    String name;
    String voice;
    protected int flapsPer100m;
    abstract void speak();
    abstract void displayFlaps();
    Bird(String name){
        this.name = name;
    }
}
