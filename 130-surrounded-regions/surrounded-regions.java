import java.util.*;

class Solution {
    // in this question we will add all boundary 'O' into queue because all 'O' are safe that are connected to boundary 'O'.
    // we can use both dfs and bfs for adding all 'O' connected with boundary 'O'.
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Add boundary 'O' cells to queue
        // First & Last Column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
                visited[i][n - 1] = true;
            }
        }

        // First & Last Row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new int[]{0, j});
                visited[0][j] = true;
            }
            if (board[m - 1][j] == 'O') {
                queue.offer(new int[]{m - 1, j});
                visited[m - 1][j] = true;
            }
        }

        // BFS from all boundary 'O'
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'O' && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // Flip surrounded regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
