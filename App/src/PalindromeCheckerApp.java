import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}


// Stack-Based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters onto stack
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare characters while popping
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


// Deque-Based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to deque
        for (char ch : normalized.toCharArray()) {
            deque.add(ch);
        }

        // Compare from both ends
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }

    // Approach 3: Using recursion
    public static boolean isPalindromeRecursive(String str) {
        return checkPalindromeRecursive(str, 0, str.length() - 1);
    }

// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    // Constructor Injection
    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}


// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "Race car";   // Change input if needed

        // Choose strategy dynamically
        PalindromeStrategy strategy = new StackStrategy();
        // You can switch to:
        // PalindromeStrategy strategy = new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(input);

        // Measure Approach 3
        long start3 = System.nanoTime();
        boolean result3 = isPalindromeRecursive(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // Display Results
        System.out.println("\n--- Palindrome Results ---");
        System.out.println("Using StringBuilder reverse: " + result1 + " (Time: " + time1 + " ns)");
        System.out.println("Using Two-Pointer technique: " + result2 + " (Time: " + time2 + " ns)");
        System.out.println("Using Recursion: " + result3 + " (Time: " + time3 + " ns)");
    }
}