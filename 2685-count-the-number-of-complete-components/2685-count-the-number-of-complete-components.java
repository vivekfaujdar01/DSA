class Solution {
    // Total edges = (sum of degrees) / 2
    // A connected component is complete if: Every pair of nodes inside it has a direct edge.
    // In simple words: If component has k nodes, Then it must have k * (k - 1) / 2 edges
    public int countCompleteComponents(int n, int[][] edges) {
        
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        int completeCount = 0;
        
        // Traverse each node
        for (int i = 0; i < n; i++) {
            
            if (!visited[i]) {
                
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                
                int nodes = 0;
                int degreeSum = 0;
                
                // BFS traversal
                while (!queue.isEmpty()) {
                    
                    int current = queue.poll();
                    nodes++;
                    
                    degreeSum += graph.get(current).size();
                    
                    for (int neighbor : graph.get(current)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
                
                int actualEdges = degreeSum / 2;
                int requiredEdges = nodes * (nodes - 1) / 2;
                
                if (actualEdges == requiredEdges) {
                    completeCount++;
                }
            }
        }
        
        return completeCount;
    }
}