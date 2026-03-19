class NumMatrix {
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        prefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (i > 0) {
                    value += prefix[i - 1][j];
                }
                if (j > 0) {
                    value += prefix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    value -= prefix[i - 1][j - 1];
                }
                prefix[i][j] = value;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = prefix[row2][col2];

        if (row1 > 0) {
            sum -= prefix[row1 - 1][col2];
        }
        if (col1 > 0) {
            sum -= prefix[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            sum += prefix[row1 - 1][col1 - 1];
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */