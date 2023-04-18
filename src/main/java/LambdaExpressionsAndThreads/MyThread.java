package LambdaExpressionsAndThreads;

public class MyThread extends Thread {
    private int num;

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i=1;i<=5;i++){
            System.out.println(num + " numbered thread: " + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
