class Solution {
    // in this we will check two adjacent should not have same color.
    // we will start with starting node and use bfs traversal to check that adjacent node don't have similar color
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            color[i] = -1;
        }

        for(int i=0;i<graph.length;i++){
            if(color[i] == -1){
                if(bfs(i,graph,color) == false){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int node, int[][] graph, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 0;

        while(!queue.isEmpty()){

            int nod = queue.poll();
            for(int adj : graph[nod]){

                if(color[adj] == -1){
                    color[adj] = 1 - color[nod];
                    queue.add(adj);
                }
                else if(color[adj] == color[nod]){
                    return false;
                }

            }

        }

        return true;
    }
}