import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        boolean result;

        if (choice == 1) {
            result = stackStrategy(input);
        } else {
            result = dequeStrategy(input);
        }

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Strategy 1: Stack
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

    // Strategy 2: Deque
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