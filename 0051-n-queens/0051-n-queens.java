class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, n);

        return ans;
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


// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> res = new ArrayList<>();
//         List<String> configuration = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();

//         for (int i = 0; i < n; i++) {
//             sb.append('.');
//         }

//         for (int i = 0; i < n; i++) {
//             configuration.add(sb.toString());
//         }

//         int col = 0;
//         rec(col, n, configuration, res);
//         return res;
//     }

//     void rec(int col, int n, List<String> config, List<List<String>> res) {
//         // base case
//         if (col == n) {
//             res.add(new ArrayList<>(config));
//             return;
//         }

//         // recur calls
//         for (int row = 0; row < n; row++) {
//             if (canPlaced(n, row, col, config)) {
//                 String old = config.get(row);
//                 config.set(row, old.substring(0, col) + "Q" + old.substring(col + 1));

//                 rec(col + 1, n, config, res);

//                 config.set(row, old);
//             }
//         }
//     }

//     boolean canPlaced(int n, int row, int col, List<String> config) {
//         // Check left in the same row
//         for (int j = 0; j < col; j++) {
//             if (config.get(row).charAt(j) == 'Q') {
//                 return false;
//             }
//         }

//         // Check upper-left diagonal
//         int i = row;
//         int j = col;
//         while (i >= 0 && j >= 0) {
//             if (config.get(i).charAt(j) == 'Q') {
//                 return false;
//             }
//             i--;
//             j--;
//         }

//         // Check lower-left diagonal
//         i = row;
//         j = col;
//         while (i < n && j >= 0) {
//             if (config.get(i).charAt(j) == 'Q') {
//                 return false;
//             }
//             i++;
//             j--;
//         }

//         return true;
//     }
// }