class Solution {
    // DFS Solution 
    // If two stones share same row OR same column -> they are connected 
    // Find number of connected components in this graph
    // Answer = total stones − number of components
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(stones, visited, i);
                components++;
            }
        }

        return n - components;
    }

    private void dfs(int[][] stones, boolean[] visited, int index) {
        visited[index] = true;

        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] && (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])){
                dfs(stones, visited, i);
            }
        }
    }
}

// class Solution {
//     public int removeStones(int[][] stones) {
//         int n = stones.length;
//         boolean[] visited = new boolean[n];
//         int components = 0;
// 
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 bfs(stones, visited, i);
//                 components++;
//             }
//         }
// 
//         return n - components;
//     }
// 
//     private void bfs(int[][] stones, boolean[] visited, int start) {
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(start);
//         visited[start] = true;
// 
//         while (!queue.isEmpty()) {
//             int index = queue.poll();
// 
//             for (int i = 0; i < stones.length; i++) {
//                 if (!visited[i] && (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])) {
//                     visited[i] = true;
//                     queue.add(i);
//                 }
//             }
//         }
//     }
// }