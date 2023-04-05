package BIL211Calısma;

public class TestPairAndStack {
    public static void main(String[] args) {
        // Test Pair class
        Pair<Integer, String> pair = new Pair<>(10, "Hello");
        System.out.println(pair.getFirst()); // output: 10
        System.out.println(pair.getSecond()); // output: Hello
        System.out.println(pair.toString()); // output: (10, Hello)

        // Test Stack class
        Stack<Integer> stack = new Stack<>(10);
        System.out.println(stack.isEmpty()); // output: true
        System.out.println(stack.size()); // output: 0

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isEmpty()); // output: false
        System.out.println(stack.size()); // output: 3
        System.out.println(stack.peek()); // output: 3
        System.out.println(stack.pop()); // output: 3
        System.out.println(stack.peek()); // output: 2
        System.out.println(stack.pop()); // output: 2
        System.out.println(stack.pop()); // output: 1
        System.out.println(stack.isEmpty()); // output: true
    }
}
