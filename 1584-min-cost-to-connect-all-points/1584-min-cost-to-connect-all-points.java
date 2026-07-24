class Solution {
    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                Edge e = new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                edges.add(e);
            }
        }

        Collections.sort(edges, (a, b) -> a.weight - b.weight);
        int V = points.length;
        DisjointSet ds = new DisjointSet(V);

        int mstWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {

            int u = edge.src;
            int v = edge.dest;

            if (ds.find(u) != ds.find(v)) {

                ds.union(u, v);
                mstWeight += edge.weight;
                edgeCount++;

                if (edgeCount == V - 1)
                    break;
            }
        }

        return mstWeight;
    }
}
