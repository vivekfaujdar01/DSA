class Solution {
    // in this the nodes who leads for cycle and involve cycle in this graph are not safe nodes
    // so marking safe nodes as 1 in check array
    
    private boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check) {

        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;  // Assume unsafe initially

        for (int neighbor : adj.get(node)) {

            // If not visited
            if (vis[neighbor] == 0) {
                if (dfsCheck(neighbor, adj, vis, pathVis, check)) {
                    check[neighbor] = 0;
                    return true;  // cycle found
                }
            }
            // If visited and in same DFS path → cycle
            else if (pathVis[neighbor] == 1) {
                check[neighbor] = 0;
                return true;
            }
        }

        // No cycle found -> mark safe
        check[node] = 1;
        pathVis[node] = 0;   // remove from recursion stack
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        // Convert int[][] to adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            for (int neighbor : graph[i]) {
                adj.get(i).add(neighbor);
            }
        }

        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}
