import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Stack strategy performance
        long startStack = System.nanoTime();
        boolean stackResult = stackStrategy(input);
        long endStack = System.nanoTime();

        // Deque strategy performance
        long startDeque = System.nanoTime();
        boolean dequeResult = dequeStrategy(input);
        long endDeque = System.nanoTime();

        System.out.println("\nResults:");

        System.out.println("Stack Strategy Result: " + stackResult);
        System.out.println("Stack Execution Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque Strategy Result: " + dequeResult);
        System.out.println("Deque Execution Time: " + (endDeque - startDeque) + " ns");

        scanner.close();
    }

    // Stack strategy
    public static boolean stackStrategy(String input) {

        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : processed.toCharArray()) {
            stack.push(c);
        }

        for (char c : processed.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque strategy
    public static boolean dequeStrategy(String input) {

        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : processed.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}