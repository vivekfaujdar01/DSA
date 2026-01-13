class NeighborSum {
    private int[][] grid;
    private int n;
    private Map<Integer, int[]> position;

    // Constructor
    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        position = new HashMap<>();

        // Store position of each value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                position.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    // Sum of adjacent neighbors (top, bottom, left, right)
    public int adjacentSum(int value) {
        int[] pos = position.get(value);
        int r = pos[0], c = pos[1];
        int sum = 0;

        int[][] directions = {
            {-1, 0}, // top
            {1, 0},  // bottom
            {0, -1}, // left
            {0, 1}   // right
        };

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                sum += grid[nr][nc];
            }
        }

        return sum;
    }

    // Sum of diagonal neighbors
    public int diagonalSum(int value) {
        int[] pos = position.get(value);
        int r = pos[0], c = pos[1];
        int sum = 0;

        int[][] directions = {
            {-1, -1}, // top-left
            {-1, 1},  // top-right
            {1, -1},  // bottom-left
            {1, 1}    // bottom-right
        };

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                sum += grid[nr][nc];
            }
        }

        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */