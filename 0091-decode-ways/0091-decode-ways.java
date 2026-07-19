class Solution {

    public int numDecodings(String s) {
        return solve(0, s);
    }

    private int solve(int i, String s) {

        // Successfully decoded the whole string
        if (i == s.length()) {
            return 1;
        }

        // Strings starting with 0 are invalid
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Option 1: Take one digit
        int oneDigit = solve(i + 1, s);

        // Option 2: Take two digits (if valid)
        int twoDigit = 0;

        if (i + 1 < s.length()) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');

            if (num >= 10 && num <= 26) {
                twoDigit = solve(i + 2, s);
            }
        }

        return oneDigit + twoDigit;
    }
}