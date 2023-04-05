package BIL211Calısma;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    List<T> stack = new ArrayList<T>();

    public Stack(int a) {
    }

    public void push(T t){
        stack.add(t);
    }
    public T pop(){
        T t = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return t;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int size(){
        return stack.size();
    }
    public T peek(){
        return stack.get(stack.size()-1);
    }
}
