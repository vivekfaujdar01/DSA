class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] front = new int[n];

        // Base case
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];

            for (int j = 0; j <= i; j++) {
                int down = front[j];
                int diag = front[j + 1];

                curr[j] = triangle.get(i).get(j) + Math.min(down, diag);
            }

            front = curr;
        }

        return front[0];
    }
}

// class Solution {
//     // Tabulation 
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][n];

//         // Fill last row
//         for (int j = 0; j < n; j++) {
//             dp[n - 1][j] = triangle.get(n - 1).get(j);
//         }

//         // Build from bottom to top
//         for (int i = n - 2; i >= 0; i--) {
//             for (int j = 0; j <= i; j++) {
//                 int down = triangle.get(i).get(j) + dp[i + 1][j] ;
//                 int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1] ;
//                 dp[i][j] =  Math.min(down, diagonal);
//             }
//         }

//         return dp[0][0];
//     }
// }

// recursion 
// public int minimumTotal(List<List<Integer>> triangle) {
//     return solve(0, 0, triangle);
// }

// private int solve(int i, int j, List<List<Integer>> triangle) {
//     // Base case: last row
//     if (i == triangle.size() - 1) {
//         return triangle.get(i).get(j);
//     }

//     int down = triangle.get(i).get(j) + solve(i + 1, j, triangle);
//     int diagonal = triangle.get(i).get(j) + solve(i + 1, j + 1, triangle);

//     return Math.min(down, diagonal);
// }