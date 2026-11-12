class Solution {
    // Space Optimization
    public int findLength(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[] prev = new int[m + 1];

        int maxLength = 0;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {

                if (nums1[i - 1] == nums2[j - 1]) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = 0;
                }

                maxLength = Math.max(maxLength, curr[j]);
            }

            prev = curr;
        }

        return maxLength;
    }
}

// // Tabulation(Bottom-Up)
// // Time Complexity: O(nm) and we use int[][] dp = new int[n + 1][m + 1] to avoid negative indexing
// class Solution {
//     public int findLength(int[] nums1, int[] nums2) {

//         int n = nums1.length;
//         int m = nums2.length;

//         int[][] dp = new int[n + 1][m + 1];

//         int maxLength = 0;

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {

//                 if (nums1[i - 1] == nums2[j - 1]) {

//                     dp[i][j] = 1 + dp[i - 1][j - 1];

//                 } else {

//                     dp[i][j] = 0;
//                 }

//                 maxLength = Math.max(maxLength, dp[i][j]);
//             }
//         }

//         return maxLength;
//     }
// }


// // // Memoization Top-Down
// // // Time Complexity: O(nm)
// // class Solution {
// //     int maxLength = 0;
// //     public int findLength(int[] nums1, int[] nums2) {

// //         int n = nums1.length;
// //         int m = nums2.length;
// //         int[][] dp = new int[n][m];

// //         for (int i = 0; i < n; i++) {
// //             Arrays.fill(dp[i], -1);
// //         }

// //         for (int i = n - 1; i >= 0; i--) {
// //             for (int j = m - 1; j >= 0; j--) {
// //                 solve(nums1, nums2, i, j, dp);
// //             }
// //         }

// //         return maxLength;
// //     }

// //     private int solve(int[] nums1, int[] nums2, int i, int j, int[][] dp) {

// //         if (i < 0 || j < 0) {
// //             return 0;
// //         }

// //         if (dp[i][j] != -1) {
// //             return dp[i][j];
// //         }

// //         int length = 0;

// //         if (nums1[i] == nums2[j]) {
// //             length = 1 + solve(nums1, nums2, i - 1, j - 1, dp);
// //         }

// //         dp[i][j] = length;

// //         maxLength = Math.max(maxLength, length);

// //         return dp[i][j];
// //     }
// // }
