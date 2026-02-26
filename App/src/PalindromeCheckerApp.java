import java.util.Scanner;

public class PalindromeCheckerApp {

    // Function to normalize string (remove spaces & ignore case)
    public static String normalize(String str) {
        return str.replaceAll("\\s+", "").toLowerCase();
    }

    // Palindrome check using two-pointer
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        String normalized = normalize(input);

        if (isPalindrome(normalized)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}