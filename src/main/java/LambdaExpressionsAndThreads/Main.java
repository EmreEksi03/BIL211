package LambdaExpressionsAndThreads;

public class Main {
    public static void main(String[] args) {
        /*
        Printable example = () -> {
            System.out.println("456");
        };
        printThing(example);
        printThing(()-> {
            System.out.println("123");
        });
        */
        MyThread myThread = new MyThread();
        myThread.setNum(1);
        MyThread myThread2 = new MyThread();
        myThread2.setNum(2);
        MyThread myThread3 = new MyThread();
        myThread3.setNum(3);
        myThread.start();
        myThread2.start();
        myThread3.start();
    }
    static void printThing(Printable thing){
        thing.print();
    }
}
