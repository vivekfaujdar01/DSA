class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] indegree = new int[n];
        
        // Calculate indegree
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                indegree[edges[i]]++;
            }
        }

        // Remove nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        boolean[] removed = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            removed[node] = true;

            int neighbor = edges[node];
            if (neighbor != -1) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Remaining nodes form cycles
        boolean[] visited = new boolean[n];
        int maxCycle = -1;

        for (int i = 0; i < n; i++) {
            if (!removed[i] && !visited[i]) {
                int current = i;
                int count = 0;

                while (!visited[current]) {
                    visited[current] = true;
                    count++;
                    current = edges[current];
                }

                maxCycle = Math.max(maxCycle, count);
            }
        }

        return maxCycle;
    }
}
