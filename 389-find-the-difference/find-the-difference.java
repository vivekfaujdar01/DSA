class Solution {
    public char findTheDifference(String s, String t) {
        // Steps:
        // Sum ASCII values of t
        // Subtract ASCII values of s
        // Convert remaining value to character
        int sum = 0;
        for (char c : t.toCharArray())
            sum += c;
        for (char c : s.toCharArray())
            sum -= c;
        return (char) sum;
    }
}