import java.util.*;

class Solution {
    // same approach as 130. Surrounded Regions just reverse of this.
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all boundary land cells to queue
        for (int i = 0; i < m; i++) {
            // First column
            if (grid[i][0] == 1 && !visited[i][0]) {
                queue.offer(new int[]{i, 0});
                visited[i][0] = true;
            }
            // Last column
            if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
                queue.offer(new int[]{i, n - 1});
                visited[i][n - 1] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            // First row
            if (grid[0][j] == 1 && !visited[0][j]) {
                queue.offer(new int[]{0, j});
                visited[0][j] = true;
            }
            // Last row
            if (grid[m - 1][j] == 1 && !visited[m - 1][j]) {
                queue.offer(new int[]{m - 1, j});
                visited[m - 1][j] = true;
            }
        }

        // Directions: up, down, left, right
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        // BFS from boundary land
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // Count land cells not visited
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
