class Solution {
    // this is same as Q. 542 : 01 Matrix, the difference is just we have to find nearest distance to 1 for each cell 
    
    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        // Add all water cells to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0}); // row, col, height
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int currHeight = current[2];

            height[row][col] = currHeight;

            for (int i = 0;i < 4;i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
   
                    visited[newRow][newCol] = true;

                    queue.offer(new int[]{newRow, newCol, currHeight + 1});
                }
            }
        }

        return height;
    }
}
