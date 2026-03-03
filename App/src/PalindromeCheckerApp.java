import java.util.*;

public class PalindromeCheckerApp {

    // Normalize input (remove spaces & convert to lowercase)
    public static String normalize(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    // Approach 1: StringBuilder Reverse
    public static boolean checkUsingReverse(String input) {
        String normalized = normalize(input);
        String reversed = new StringBuilder(normalized).reverse().toString();
        return normalized.equals(reversed);
    }

    // Approach 2: Two Pointer Technique
    public static boolean checkUsingTwoPointer(String input) {
        String normalized = normalize(input);
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

    // Approach 3: Stack
    public static boolean checkUsingStack(String input) {
        String normalized = normalize(input);
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

    // Approach 4: Recursion
    public static boolean checkUsingRecursion(String input) {
        String normalized = normalize(input);
        return recursiveCheck(normalized, 0, normalized.length() - 1);
    }

    private static boolean recursiveCheck(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return recursiveCheck(str, left + 1, right - 1);
    }

    // ===================== MAIN ======================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC13) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\n--- Performance Comparison ---");

        // Approach 1
        long start1 = System.nanoTime();
        boolean result1 = checkUsingReverse(input);
        long end1 = System.nanoTime();

        // Approach 2
        long start2 = System.nanoTime();
        boolean result2 = checkUsingTwoPointer(input);
        long end2 = System.nanoTime();

        // Approach 3
        long start3 = System.nanoTime();
        boolean result3 = checkUsingStack(input);
        long end3 = System.nanoTime();

        // Approach 4
        long start4 = System.nanoTime();
        boolean result4 = checkUsingRecursion(input);
        long end4 = System.nanoTime();

        // Display Results
        System.out.println("Using StringBuilder Reverse: " + result1 + 
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Using Two Pointer: " + result2 + 
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Using Stack: " + result3 + 
                " | Time: " + (end3 - start3) + " ns");

        System.out.println("Using Recursion: " + result4 + 
                " | Time: " + (end4 - start4) + " ns");

        scanner.close();
    }
}
