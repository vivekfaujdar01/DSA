class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;

        int prefixSum[][] = new int[r][c];
        // STEP 1: Create prefix sum matrix
        // prefix[i][j] stores sum of all elements
        // from (0,0) to (i,j)
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                // Start with current cell value
                prefixSum[i][j] = mat[i][j];
                // Add sum from above row (if exists)
                if(i > 0) prefixSum[i][j] += prefixSum[i-1][j];
                // Add sum from left column (if exists)
                if(j > 0) prefixSum[i][j] += prefixSum[i][j-1];
                // Subtract overlap (added twice above)
                if(i > 0 && j > 0) prefixSum[i][j] -= prefixSum[i-1][j-1]; 
            }
        }

        int res[][] = new int[r][c];
        // STEP 2: Calculate block sum for each cell
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                // Define block boundaries
                // Ensure indices stay inside matrix
                int r1 = Math.max(0, i-k);  // top row
                int c1 = Math.max(0, j-k);  // left column
                int r2 = Math.min(r-1, i+k); // bottom row
                int c2 = Math.min(c-1, j+k); // right column
                // Start with sum from (0,0) to (r2,c2)
                res[i][j] = prefixSum[r2][c2];
                // Remove rows above r1
                if(r1 > 0) res[i][j] -= prefixSum[r1-1][c2];
                // Remove columns left of c1
                if(c1 > 0) res[i][j] -= prefixSum[r2][c1-1];
                // Add back overlapped area
                if(r1 > 0 && c1 > 0) res[i][j] += prefixSum[r1-1][c1-1];
            }
        }
        return res;
    }
}