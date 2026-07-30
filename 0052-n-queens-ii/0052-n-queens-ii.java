class Solution {
    List<List<String>> ans = new ArrayList<>();

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, n);

        return ans.size();
    }

    // col represents the current column
    private void solve(int col, char[][] board, int n) {

        // All columns processed
        if (col == n) {
            ans.add(build(board));
            return;
        }

        // Try placing the queen in every row of this column
        for (int row = 0; row < n; row++) {

            if (isSafe(row, col, board, n)) {

                board[row][col] = 'Q';

                solve(col + 1, board, n);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {

        // Check left side of the same row
        for (int j = col - 1; j >= 0; j--) {
            if (board[row][j] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check lower-left diagonal
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    private List<String> build(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        return list;
    }
}
