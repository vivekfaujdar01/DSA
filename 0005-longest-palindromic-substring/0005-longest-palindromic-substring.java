class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (isPalindrome(i, j, s)) {
                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(int i, int j, String s) {
        if (i >= j) return true;

        if (s.charAt(i) != s.charAt(j)) return false;

        return isPalindrome(i + 1, j - 1, s);
    }
}