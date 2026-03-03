import java.util.*;

public class PalindromeCheckerApp {

    //  Two-Pointer Approach
    public static boolean twoPointerCheck(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Stack-Based Approach
    public static boolean stackCheck(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Recursive Approach
    public static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return recursiveCheck(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Two Pointer Timing
        long startTime = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long endTime = System.nanoTime();
        long duration1 = endTime - startTime;

        // Stack Timing
        startTime = System.nanoTime();
        boolean result2 = stackCheck(input);
        endTime = System.nanoTime();
        long duration2 = endTime - startTime;

        // Recursive Timing
        startTime = System.nanoTime();
        boolean result3 = recursiveCheck(normalized, 0, normalized.length() - 1);
        endTime = System.nanoTime();
        long duration3 = endTime - startTime;

        System.out.println("Input: \"" + input + "\"\n");

        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Execution Time: " + duration1 + " ns\n");

        System.out.println("Stack Result: " + result2);
        System.out.println("Execution Time: " + duration2 + " ns\n");

        System.out.println("Recursive Result: " + result3);
        System.out.println("Execution Time: " + duration3 + " ns\n");

        System.out.println("Performance Comparison Completed.");
    }
}