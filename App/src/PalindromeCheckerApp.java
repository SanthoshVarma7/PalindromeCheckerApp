class PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base Condition: If pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters at start and end don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for remaining substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String input = "madam";   // You can change the input here

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }
}