class Solution {

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        solve(s, 0);
        return ans;
    }

    private void solve(String s, int index) {

        // Base case
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try every possible substring starting from index
        for (int end = index; end < s.length(); end++) {

            if (isPalindrome(s, index, end)) {

                // Choose
                path.add(s.substring(index, end + 1));

                // Explore
                solve(s, end + 1);

                // Backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}