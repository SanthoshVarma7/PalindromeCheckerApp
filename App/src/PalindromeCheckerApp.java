import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        // Convert String to Character Array
        char[] characters = input.toCharArray();

        // Two-pointer approach
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {

            // Compare start and end characters
            if (characters[left] != characters[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
