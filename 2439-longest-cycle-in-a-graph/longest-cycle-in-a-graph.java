class Solution {
    // A node can only belong to one cycle
    // Once visited globally, we never need to process it again
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int maxCycle = -1;

        for (int i = 0; i < n; i++) {

            // If already processed, skip
            if (visited[i]) continue;

            Map<Integer, Integer> map = new HashMap<>();
            int current = i;
            int step = 0;

            // Traverse until:
            // 1) No outgoing edge (-1)
            // 2) Node already globally visited
            while (current != -1 && !visited[current]) {

                visited[current] = true;
                map.put(current, step);

                step++;
                current = edges[current];
            }

            // If current node is part of this traversal path -> cycle found
            if (current != -1 && map.containsKey(current)) {
                int cycleLength = step - map.get(current);
                maxCycle = Math.max(maxCycle, cycleLength);
            }
        }

        return maxCycle;
    }
}
