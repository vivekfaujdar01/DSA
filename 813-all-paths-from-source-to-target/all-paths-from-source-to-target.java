class Solution {
    // DFS + Backtracking
    // No visited array (DAG guarantee)
    // Since we need all paths from source to target in a DAG, I used DFS with backtracking.I maintain a current path list and whenever I reach the target node, I store a copy of it in the result.Because the graph is acyclic, I don’t need a visited array.
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph.length-1, graph, path, result);
        return result;

    }
    static void dfs(int node, int dest, int[][] adj, List<Integer> path,List<List<Integer>> result){

        path.add(node);

        if (node == dest) {
            result.add(new ArrayList<>(path));
        } else {
            for (int neighbor : adj[node]) {
                dfs(neighbor, dest, adj, path, result);
            }
        }

        path.remove(path.size() - 1); // backtrack
    }
}