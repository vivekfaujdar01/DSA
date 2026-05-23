class Solution {
    public int minReorder(int n, int[][] connections) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new int[]{v, 1}); // Original direction u -> v

            adj.get(v).add(new int[]{u, 0}); // Reverse direction
        }

        boolean[] visited = new boolean[n];

        return dfs(0, adj, visited);
    }

    private int dfs(int node, List<List<int[]>> adj, boolean[] visited) {

        visited[node] = true;

        int changes = 0;

        for(int[] nei : adj.get(node)) {

            int next = nei[0];
            int cost = nei[1];

            if(!visited[next]) {

                changes += cost;

                changes += dfs(next, adj, visited);
            }
        }

        return changes;
    }
}