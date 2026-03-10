import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        PalindromeCheckerApp checker = new PalindromeCheckerApp();

        if (checker.checkPalindrome(input)) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Palindrome checking method
    public boolean checkPalindrome(String input) {

        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = processed.length() - 1;

        while (left < right) {

            if (processed.charAt(left) != processed.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}