class Solution {
    // space optimization
    public int numDecodings(String s) {
        int n = s.length();

        int next = 1; // Base Case
        int secNext = 0;

        for (int i = n - 1; i >= 0; i--) {

            int curr = 0;
            // Cannot decode a string starting with 0
            if (s.charAt(i) == '0') { // important, updating the values in it also 
                curr = 0;
                secNext = next;
                next = curr;
                continue;
            }

            // Take one digit
            int oneDigit = next;

            // Take two digits if valid
            int twoDigit = 0;

            if (i + 1 < n) {

                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');

                if (num >= 10 && num <= 26) {
                    twoDigit = secNext;
                }
            }

            curr = oneDigit + twoDigit;

            secNext = next;
            next = curr;
        }

        return next;
    }
}
