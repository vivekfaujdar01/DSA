class Solution {
    static class Pair {
        int node;
        long dist;
        
        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        
        // Modulo value
        int MOD = 1000000007;
        
        // Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            
            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }
        
        // Distance & Ways arrays
        long[] dist = new long[n];
        long[] ways = new long[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[0] = 0;
        ways[0] = 1;
        
        // Min Heap (distance based)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        
        pq.offer(new Pair(0, 0));
        
        // Dijkstra
        while (!pq.isEmpty()) {
            
            Pair current = pq.poll();
            int node = current.node;
            long currentDist = current.dist;
            
            // Skip outdated entries
            if (currentDist > dist[node]) continue;
            
            for (Pair neighbor : adj.get(node)) {
                
                int nextNode = neighbor.node;
                long newDist = currentDist + neighbor.dist;
                
                // Found shorter path
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];
                    pq.offer(new Pair(nextNode, newDist));
                }
                
                // Found another shortest path
                else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return (int)(ways[n - 1] % MOD);
    }
}