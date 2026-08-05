class Solution {
    // in this the trick is if any safe node is invoking any suspicious node then all suspicious nodes will become safe nodes
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // Build Graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Find all suspicious methods
        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        // Check if any safe node points to a suspicious node
        for (int[] edge : invocations) {

            int from = edge[0];
            int to = edge[1];

            if (!suspicious[from] && suspicious[to]) {

                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }

                return ans;
            }
        }

        // Collect remaining (safe) methods
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    void dfs(int node, List<List<Integer>> graph, boolean[] suspicious) {

        suspicious[node] = true;

        for (int next : graph.get(node)) {

            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }
}