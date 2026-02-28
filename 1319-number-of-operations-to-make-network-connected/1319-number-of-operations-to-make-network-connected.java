class Solution {
    // Using Disjoint Set by counting extra edges and components
    public int makeConnected(int n, int[][] connections) {

        DSU dsu = new DSU(n);
        int extraEdges = 0;

        for (int[] conn : connections) {
            if (!dsu.union(conn[0], conn[1])) {
                extraEdges++; // count redundant cable
            }
        }

        // Count components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                components++;
            }
        }

        int needed = components - 1;

        if (extraEdges >= needed) {
            return needed;
        }

        return -1;
    }

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path Compression
            }
            return parent[x];
        }

        // returns true if union happened
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false; // Extra edge (cycle)
            }

            // Union by Rank
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }
    }

}