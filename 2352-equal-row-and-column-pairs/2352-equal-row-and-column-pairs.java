class Solution {
    public int equalPairs(int[][] grid) {

        int n = grid.length;

        HashMap<String, Integer> map = new HashMap<>();

        // Store all rows
        for (int i = 0; i < n; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(",");
            }

            String row = sb.toString();

            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        int count = 0;

        // Build each column
        for (int j = 0; j < n; j++) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append(",");
            }

            String col = sb.toString();

            count += map.getOrDefault(col, 0);
        }

        return count;
    }
}