import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive palindrome check
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition: pointers crossed or met
        if (start >= end) {
            return true;
        }

        // If mismatch found
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}