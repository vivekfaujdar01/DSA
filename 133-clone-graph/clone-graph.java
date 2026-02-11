/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        
        // Edge case: empty graph
        if (node == null) {
            return null;
        }
        
        // Map to store original -> clone mapping
        Map<Node, Node> map = new HashMap<>();
        
        // Queue for BFS
        Queue<Node> queue = new LinkedList<>();
        
        // Clone the first node
        Node cloneNode = new Node(node.val);
        
        // Store mapping
        map.put(node, cloneNode);
        
        // Add original node to queue
        queue.offer(node);
        
        // BFS traversal
        while (!queue.isEmpty()) {
            
            Node current = queue.poll();
            
            for (Node neighbor : current.neighbors) {
                
                // If neighbor not cloned yet
                if (!map.containsKey(neighbor)) {
                    
                    // Clone it
                    Node neighborClone = new Node(neighbor.val);
                    
                    // Store in map
                    map.put(neighbor, neighborClone);
                    
                    // Add original neighbor to queue
                    queue.offer(neighbor);
                }
                
                // Add cloned neighbor to cloned current node
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        
        // Return clone of starting node
        return cloneNode;
    }
}
