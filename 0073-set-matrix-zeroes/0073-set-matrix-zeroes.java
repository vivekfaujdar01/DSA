class Solution {
    // Using first row & first column as storage
    // Instead of separate arrays: matrix[i][0] -> marks row , matrix[0][j] -> marks column
    // matrix[0][0] represents both row & column. So we use an extra variable: int col0 = 1;
    // Step1: Mark rows & cols
        // Traverse matrix
        // If matrix[i][j] == 0:
        // mark matrix[i][0] = 0
        // mark matrix[0][j] = 0
        // if j == 0 → update col0
    // Step2: Fill matrix (reverse traversal)
        // Avoid overwriting markers
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int col0 = 1;

        // Mark rows and columns
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = 0;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Update matrix in reverse
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}

// Time: O(m × n) and Space: O(m + n)
// public void setZeroes(int[][] matrix) {
//     int m = matrix.length;
//     int n = matrix[0].length;

//     int[] row = new int[m];
//     int[] col = new int[n];

//     // mark rows and cols
//     for (int i = 0; i < m; i++) {
//         for (int j = 0; j < n; j++) {
//             if (matrix[i][j] == 0) {
//                 row[i] = 1;
//                 col[j] = 1;
//             }
//         }
//     }

//     // update matrix
//     for (int i = 0; i < m; i++) {
//         for (int j = 0; j < n; j++) {
//             if (row[i] == 1 || col[j] == 1) {
//                 matrix[i][j] = 0;
//             }
//         }
//     }
// }