class Pair {
    int first, second;
    
    Pair(int first, int second) {
        this.first = first;   // node
        this.second = second; // weight
    }
}
class Tuple {
    int first, second, third;
    
    Tuple(int first, int second, int third) {
        this.first = first;   // stops
        this.second = second; // node
        this.third = third;   // cost
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // Adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(
                new Pair(flights[i][1], flights[i][2])
            );
        }

        // Queue for BFS: {stops, node, cost}
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;

        while (!q.isEmpty()) {

            Tuple it = q.poll();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            // If stops exceed K, skip
            if (stops > K) continue;

            for (Pair iter : adj.get(node)) {

                int adjNode = iter.first;
                int edW = iter.second;

                if (cost + edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }

        if (dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}