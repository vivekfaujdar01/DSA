class Solution {
    // we are using Floyd Warshall to solve we will find shortest path between every pair 
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];
        
        // Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
            dist[i][i] = 0;
        }
        
        // Fill edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            dist[u][v] = w;
            dist[v][u] = w;  // because bidirectional
        }
        
        // Floyd Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // Find city with smallest reachable cities
        int minCount = Integer.MAX_VALUE;
        int resultCity = -1;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            
            // Important: use <= for tie-breaking
            if (count <= minCount) {
                minCount = count;
                resultCity = i;
            }
        }
        
        return resultCity;
    }
}