class Solution {
    private int count = 0, walkableCounts = 0;

    public int uniquePathsIII(int[][] grid) {
        int sr = -1, sc = -1, dr = -1, dc = -1, m = grid.length, n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                if (grid[i][j] == 2) {
                    dr = i;
                    dc = j;
                }
                if (grid[i][j] != -1) {
                    walkableCounts++;
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        solve(sr, sc, dr, dc, m, n, visited, grid, 1);
        return count;
    }

    private void solve(int sr, int sc, int dr, int dc, int m, int n, boolean[][] visited, int[][] grid,
            int vistedCount) {

        if (sr < 0 || sr >= m || sc < 0 || sc >= n || visited[sr][sc] || grid[sr][sc] == -1) {
            return;
        }

        visited[sr][sc] = true;

        if (sr == dr && sc == dc ) {
            if(walkableCounts == vistedCount){
                count++;
            }
            visited[sr][sc] = false;
            return;
        } else {

            solve(sr, sc + 1, dr, dc, m, n, visited, grid, vistedCount + 1); // right
            solve(sr + 1, sc, dr, dc, m, n, visited, grid, vistedCount + 1); // down
            solve(sr, sc - 1, dr, dc, m, n, visited, grid, vistedCount + 1); // left
            solve(sr - 1, sc, dr, dc, m, n, visited, grid, vistedCount + 1); // up

            visited[sr][sc] = false;
        }

    }
}