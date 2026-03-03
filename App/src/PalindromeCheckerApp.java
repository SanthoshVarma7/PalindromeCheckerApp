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

        String input = "Race car";   // Change input if needed

        // Choose strategy dynamically
        PalindromeStrategy strategy = new StackStrategy();
        // You can switch to:
        // PalindromeStrategy strategy = new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(input);

        if (result) {
            System.out.println("\"" + input + "\"" + " is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\"" + " is NOT a Palindrome.");
        }
    }
}