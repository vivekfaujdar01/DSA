
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;

        // Choose every cell as the top-left corner
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Try every possible square size
                int maxSize = Math.min(m - i, n - j);

                for (int size = 1; size <= maxSize; size++) {

                    boolean allOnes = true;

                    // Check every cell inside this square
                    for (int r = i; r < i + size; r++) {
                        for (int c = j; c < j + size; c++) {

                            if (matrix[r][c] == 0) {
                                allOnes = false;
                                break;
                            }
                        }

                        if (!allOnes) {
                            break;
                        }
                    }

                    if (allOnes) {
                        count++;
                    } else {
                        // Larger squares contain this invalid square
                        break;
                    }
                }
            }
        }

        return count;
    }
}
