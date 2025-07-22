// LeetCode Problem: 20. Valid Parentheses
public class ValidParenthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // Push opening brackets onto the stack
            } else {
                if (stack.isEmpty()) return false; // No matching opening bracket
                char top = stack.pop(); // Pop the last opening bracket
                if (!isMatchingPair(top, c)) return false; // Check for matching pair
            }
        }
        return stack.isEmpty(); // If stack is empty, all brackets were matched
    }
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }   
    public static void main(String[] args) {
        ValidParenthesis solution = new ValidParenthesis();
        String test1 = "()";
        String test2 = "()[]{}";
        String test3 = "(]";
        String test4 = "([])";
        String test5 = "([)]";

        System.out.println(solution.isValid(test1)); // true
        System.out.println(solution.isValid(test2)); // true
        System.out.println(solution.isValid(test3)); // false
        System.out.println(solution.isValid(test4)); // true
        System.out.println(solution.isValid(test5)); // false
    }       
}