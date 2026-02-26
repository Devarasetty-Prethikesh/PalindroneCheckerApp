import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// 1) Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// 2) Stack Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        return input.equals(reversed);
    }
}

// 3) Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// 4) Context / Service to inject strategy
class PalindromeService {
    private final PalindromeStrategy strategy;

    PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean isPalindrome(String input) {
        return strategy.check(input);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        System.out.println("Choose strategy: 1) Stack  2) Deque");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeService service = new PalindromeService(strategy);

        if (service.isPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}