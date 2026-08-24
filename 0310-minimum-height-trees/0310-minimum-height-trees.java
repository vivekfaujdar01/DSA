// 1. Root should be at the CENTER - gives minimum height.

// 2. Leaves are the outermost nodes.
//    Leaf = node whose degree == 1.

// 3. Put all leaves in a Queue.

// 4. Remove leaves layer by layer.
//    When a leaf is removed:
//       - decrease degree of its neighbor
//       - if neighbor's degree becomes 1 - it becomes a new leaf

// 5. Keep doing this while more than 2 nodes remain.

// 6. The last 1 or 2 nodes are the CENTER(S).
//    - They are the Minimum Height Tree roots.

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Special case
        if (n == 1) {
            return List.of(0);
        }
        
        List<List<Integer>> graph = new ArrayList<>(); // Adjacency list

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] degree = new int[n]; // Degree of each node

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        // Put all initial leaves into queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNodes = n;

        // Remove leaves layer by layer
        while (remainingNodes > 2) {

            int size = queue.size();

            // Remove current layer of leaves
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {

                int leaf = queue.poll();

                // Visit its neighbors
                for (int neighbor : graph.get(leaf)) {

                    degree[neighbor]--;

                    // Neighbor becomes a leaf
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Remaining 1 or 2 nodes are the centers
        return new ArrayList<>(queue);
    }
}