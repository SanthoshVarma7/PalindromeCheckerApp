import java.util.*;

// Common Interface
interface PalindromeAlgorithm {
    boolean isPalindrome(String input);
    String getName();
}

// Reverse String Strategy
class ReverseStringAlgorithm implements PalindromeAlgorithm {

    @Override
    public boolean isPalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();
        return processed.equals(reversed);
    }

    @Override
    public String getName() {
        return "Reverse String Algorithm";
    }
}

// Stack Strategy
class StackAlgorithm implements PalindromeAlgorithm {

    @Override
    public boolean isPalindrome(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return "Stack Algorithm";
    }
}

// Deque Strategy
class DequeAlgorithm implements PalindromeAlgorithm {

    @Override
    public boolean isPalindrome(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : processed.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return "Deque Algorithm";
    }
}

// Main Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App - Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // List of algorithms
        List<PalindromeAlgorithm> algorithms = Arrays.asList(
                new ReverseStringAlgorithm(),
                new StackAlgorithm(),
                new DequeAlgorithm()
        );

        System.out.println("\nRunning Performance Comparison...\n");

        for (PalindromeAlgorithm algorithm : algorithms) {

            long startTime = System.nanoTime();

            boolean result = algorithm.isPalindrome(input);

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Algorithm: " + algorithm.getName());
            System.out.println("Result   : " + (result ? "PALINDROME" : "NOT PALINDROME"));
            System.out.println("Time Taken (nanoseconds): " + duration);
            System.out.println("-----------------------------------------");
        }

        scanner.close();
    }
}