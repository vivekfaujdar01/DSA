class Solution {
    // Space Optimization
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        int[] next = new int[n];

        for (int j = 0; j < n; j++) {
            next[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + next[j];
                int diagonal = triangle.get(i).get(j) + next[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            next = curr;
        }

        return next[0];
    }
}

// Tabulation (bottom-down)

// public int minimumTotal(List<List<Integer>> triangle) {
//     int n = triangle.size();
//     int[][] dp = new int[n][n];

//     for (int j = 0; j < n; j++) {
//         dp[n - 1][j] = triangle.get(n - 1).get(j);
//     }

//     for (int i = n - 2; i >= 0; i--) {
//         for (int j = 0; j <= i; j++) {
//             int down = triangle.get(i).get(j) + dp[i + 1][j];
//             int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
//             dp[i][j] = Math.min(down, diagonal);
//         }
//     }

//     return dp[0][0];
// }

// Memoization (top-down)

// public int minimumTotal(List<List<Integer>> triangle) {
//     return rec(0, 0, triangle);
// }

// public int rec(int i, int j, List<List<Integer>> triangle) {

//     if (i == triangle.size() - 1) {
//         return triangle.get(i).get(j);
//     }

//     int down = triangle.get(i).get(j) + rec(i + 1, j, triangle);
//     int diagonal = triangle.get(i).get(j) + rec(i + 1, j + 1, triangle);

//     return Math.min(down, diagonal);
// }
