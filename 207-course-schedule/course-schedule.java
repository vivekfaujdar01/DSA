import java.util.*;

class Solution {
    // this is simple just check cycle in directed grah if there is cycle then false if no cycle then true
    // just using topoSort to detect cycle
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
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
        
        // BFS
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            
            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Check if all courses processed
        return count == numCourses;
    }
}
