package BIL211Calısma;

public class Pair <T,Q>{
    private T t;
    private Q q;
    public Pair(T t,Q q) {
        this.q = q;
        this.t = t;
    }

    public T getFirst() {
        return t;
    }

    public Q getSecond() {
        return q;
    }

    @Override
    public String toString(){
        return "first: " + t + "second: " + q;
    }
}
