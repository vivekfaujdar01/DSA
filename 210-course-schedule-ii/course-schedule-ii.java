class Solution {
    // this is same as Q. 207  Course Schedule 
    // just returning topoSort 
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Create indegree array
        int[] indegree = new int[numCourses];
        
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        
        // Add nodes with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        int[] topoSort = new int[adj.size()];

        // BFS
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topoSort[count++] = node;
            
            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Check if all courses processed
        if(count == numCourses){
            return topoSort;
        }
        else{
            return new int[]{};
        }
    }
}