// PalindromeChecker class (Encapsulated Service Class)
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize input (ignore spaces and case)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;

        // Two-pointer comparison
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}


// Main Application Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Madam";   // You can change input here

        // Create object of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("\"" + input + "\"" + " is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\"" + " is NOT a Palindrome.");
        }
    }
}