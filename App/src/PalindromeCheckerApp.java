class PalindromeCheckerApp {

    // Method to check palindrome after preprocessing
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize string
        // Remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        // Step 2: Apply palindrome logic
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";   // You can change input here

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\"" + " is a Palindrome (Ignoring spaces & case).");
        } else {
            System.out.println("\"" + input + "\"" + " is NOT a Palindrome.");
        }
    }
}