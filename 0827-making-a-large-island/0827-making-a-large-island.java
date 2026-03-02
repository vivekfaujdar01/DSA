class Solution {
    // Using DSU to solve it
    class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path Compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            // Union by Size
            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Union all 1's
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 1) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1) {
                            int node1 = r * n + c;
                            int node2 = nr * n + nc;
                            dsu.union(node1, node2);
                        }
                    }
                }
            }
        }

        int max = 0;
        boolean hasZero = false;

        // Try converting each 0
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 0) {
                    hasZero = true;
                    HashSet<Integer> set = new HashSet<>();
                    int total = 1;

                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1) {
                            int root = dsu.find(nr * n + nc);
                            set.add(root);
                        }
                    }

                    for (int root : set) {
                        total += dsu.size[root];
                    }

                    max = Math.max(max, total);
                }
            }
        }

        // If no zero exists
        if (!hasZero) return n * n;

        // Also check existing largest island (if flipping doesn't help)
        for (int i = 0; i < n * n; i++) {
            if (dsu.find(i) == i) {
                max = Math.max(max, dsu.size[i]);
            }
        }

        return max;
    }
}