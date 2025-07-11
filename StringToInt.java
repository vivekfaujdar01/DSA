//LeetCode Problem: 8. String to Integer (atoi)
// This code implements the myAtoi function which converts a string to a 32-bit signed integer.
// The function handles leading whitespace, optional sign, and conversion of numeric characters.
public class StringToInt {
    public int myAtoi(String s) {
        int i = 0, sign = 1, total = 0;
        int n = s.length();

        // Step 1: Ignore leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for sign
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert characters to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow and underflow
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            i++;
        }

        return total * sign;
    }

    public static void main(String[] args) {
        StringToInt atoi = new StringToInt();
        System.out.println(atoi.myAtoi("42")); // Output: 42
        System.out.println(atoi.myAtoi("   -42")); // Output: -42
        System.out.println(atoi.myAtoi("419 with words")); // Output: 419
        System.out.println(atoi.myAtoi("words and 987")); // Output: 0
    }
}
