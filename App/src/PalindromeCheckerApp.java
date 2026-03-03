import java.util.Scanner;

public class PalindromeCheckerApp {

    // Approach 1: Using StringBuilder reverse
    public static boolean isPalindromeUsingStringBuilder(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Approach 2: Using two-pointer technique
    public static boolean isPalindromeTwoPointer(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 3: Using recursion
    public static boolean isPalindromeRecursive(String str) {
        return checkPalindromeRecursive(str, 0, str.length() - 1);
    }

    private static boolean checkPalindromeRecursive(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        return checkPalindromeRecursive(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC13 Performance Comparison) ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine().replaceAll("\\s+", "").toLowerCase(); // normalize input

        // Measure Approach 1
        long start1 = System.nanoTime();
        boolean result1 = isPalindromeUsingStringBuilder(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Measure Approach 2
        long start2 = System.nanoTime();
        boolean result2 = isPalindromeTwoPointer(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

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