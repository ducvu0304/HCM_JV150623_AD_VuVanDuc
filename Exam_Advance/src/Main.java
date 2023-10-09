import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String str = "Peace and Quiet";
        String[] strings = str.split("\\s");

        for (int i = 0; i < strings.length ; i++) {
            stack.push(strings[i]);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

//        System.out.println("Hello world!");
    }
}