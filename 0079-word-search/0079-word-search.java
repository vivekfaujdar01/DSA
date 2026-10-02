class Solution {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        // Try every cell as a starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {

        // Out of bounds
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length) {
            return false;
        }

        // Already used in current path
        if (visited[row][col]) {
            return false;
        }

        // Character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // We found the complete word
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // Explore 4 directions
        boolean found = dfs(board, word, row + 1, col, index + 1, visited) || // down
                dfs(board, word, row - 1, col, index + 1, visited) || // up
                dfs(board, word, row, col + 1, index + 1, visited) || // right
                dfs(board, word, row, col - 1, index + 1, visited); // left

        // Backtrack: make this cell available again
        visited[row][col] = false;

        return found;
    }
}