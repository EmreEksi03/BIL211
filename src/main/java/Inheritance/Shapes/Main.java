package Inheritance.Shapes;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Shape[] arr = new Shape[3];
        arr[0] = circle;
        arr[1] = triangle;
        arr[2] = rectangle;

        for (int i=0;i<arr.length;i++){
            arr[i].displayShape();
        }

        Circle2D circle2d = new Circle2D();
        Triangle2D triangle2d = new Triangle2D();
        Rectangle2D rectangle2d = new Rectangle2D();
        Shape2D[] arr2D = new Shape2D[3];
        arr2D[0] = circle2d;
        arr2D[1] = triangle2d;
        arr2D[2] = rectangle2d;

        for (int i=0;i<arr.length;i++){
            arr2D[i].displaySides();
        }

        Sphere3d sphere3d = new Sphere3d();
        Pyramid3d pyramid3d = new Pyramid3d();
        Cube3d cube3d = new Cube3d();
        Shape3D[] arr3D = new Shape3D[3];
        arr3D[0] = sphere3d;
        arr3D[1] = pyramid3d;
        arr3D[2] = cube3d;

        for (int i=0;i<arr.length;i++){
            arr3D[i].displayShape();
            arr3D[i].displayVolume();
        }

        Shape shape1 = new Circle();
        Circle circle1 = (Circle) shape1;

        circle1.displayShape();
    }
}
