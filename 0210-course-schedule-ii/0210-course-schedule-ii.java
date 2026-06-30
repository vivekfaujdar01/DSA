class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        int[] topoSort = new int[adj.size()];

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
        
        if(count == numCourses){
            return topoSort;
        }
        else{
            return new int[]{};
        }
    }
}