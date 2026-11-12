// Memoization Top-Down
// Time Complexity: O(nm)
class Solution {
    int maxLength = 0;
    public int findLength(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                solve(nums1, nums2, i, j, dp);
            }
        }

        return maxLength;
    }

    private int solve(int[] nums1, int[] nums2, int i, int j, int[][] dp) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int length = 0;

        if (nums1[i] == nums2[j]) {
            length = 1 + solve(nums1, nums2, i - 1, j - 1, dp);
        }

        dp[i][j] = length;

        maxLength = Math.max(maxLength, length);

        return dp[i][j];
    }
}
