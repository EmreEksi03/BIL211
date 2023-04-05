package Inheritance.Shapes;

public class Shape3D extends Shape2D{
    int volume = 0;
    public void displayVolume(){
        System.out.println("Volume is " + volume);
    }
}
