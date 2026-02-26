import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Two-pointer approach
    public static boolean twoPointerCheck(String str) {
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

    // Stack approach
    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        return str.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Measure two-pointer time
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long end1 = System.nanoTime();

        // Measure stack time
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long end2 = System.nanoTime();

        System.out.println("Two-Pointer Result: " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Two-Pointer Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Result: " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Stack Time: " + (end2 - start2) + " ns");

        sc.close();
    }
}