Use Case 12 – Strategy Pattern for Palindrome Algorithms (Advanced)

Objective
To check whether a string is a palindrome by dynamically selecting a palindrome algorithm using the Strategy Design Pattern.

Flow
1. Accept input from user.
2. Define PalindromeStrategy interface.
3. Implement multiple strategies (StackStrategy, DequeStrategy).
4. Select a strategy at runtime based on user choice.
5. Inject selected strategy into PalindromeService.
6. Execute palindrome check and display result.

Concepts Used
- Interface
- Polymorphism
- Strategy Pattern
- Runtime Strategy Selection
- Object Composition

Data Structure Used
- Varies per strategy (Stack / Deque)

Branch Name
UC12-StrategyPatternPalindrome