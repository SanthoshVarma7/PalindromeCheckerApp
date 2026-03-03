import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        // Normalize string (remove spaces and convert to lowercase)
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Push all characters to stack
        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        // Compare characters while popping
        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque-based Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        // Normalize string (remove spaces and convert to lowercase)
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Add all characters to deque
        for (char ch : processed.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare from both ends
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeChecker {

    private PalindromeStrategy strategy;

    // Constructor Injection
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // Setter Injection (Optional – for dynamic change)
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (Strategy Pattern) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\nChoose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        // Inject strategy dynamically
        if (choice == 1) {
            strategy = new StackStrategy();
        } else if (choice == 2) {
            strategy = new DequeStrategy();
        } else {
            System.out.println("Invalid choice! Defaulting to Stack Strategy.");
            strategy = new StackStrategy();
        }

        PalindromeChecker checker = new PalindromeChecker(strategy);

        boolean result = checker.check(input);

        if (result) {
            System.out.println("\nResult: The string is a PALINDROME.");
        } else {
            System.out.println("\nResult: The string is NOT a palindrome.");
        }

        scanner.close();
    }
}