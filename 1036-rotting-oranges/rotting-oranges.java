class Solution {
    // Multi-source BFS -> start from all rotten oranges -> each BFS level = 1 minute.
    // we can also use visited array for this question
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // scan grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // add all rotten oranges
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // if no fresh oranges
        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // BFS
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottedThisMinute = false; // we are using this for checking only at a level

            // process one level (one minute)
            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // check boundaries and fresh orange
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;   // make it rotten
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) {
                minutes++;
            }
        }

        // Step 3: check if all fresh oranges rotted
        return freshCount == 0 ? minutes : -1;
    }
}