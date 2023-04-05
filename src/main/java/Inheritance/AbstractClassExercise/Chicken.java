package Inheritance.AbstractClassExercise;

public class Chicken extends Bird{
    Chicken(String name) {
        super(name);
    }
    int flapsPer100m = 0;
    String voice = "gdak gdak";
    @Override
    void speak() {
        System.out.println(voice);
    }

    @Override
    void displayFlaps() {
        System.out.println("This bird flaps " + flapsPer100m +  " times in 100 m flight.");
    }

    public static void main(String[] args) {
        Bird[] arr = new Bird[10];
        for (int i=0;i<10;i++){
            if (i%2==0)
                arr[i] = new Pigeon("pigeon");
            else
                arr[i] = new Chicken("chicken");
        }
        for (int i=0;i<10;i++){
            arr[i].speak();
            arr[i].displayFlaps();
        }
    }
}
