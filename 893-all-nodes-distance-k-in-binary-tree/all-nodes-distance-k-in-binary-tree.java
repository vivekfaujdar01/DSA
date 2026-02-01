/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    // in this question there is a trick we can't go back from child to parent in a tree so we will store parent node in hashmap so that we can travel upward side in tree 
    // other thing is same just use bfs algo and store node in queue and check level 
    // if same then add all nodes of that level in list and return that as a list


    // Build parent map
    private void buildParentMap(TreeNode root, TreeNode parent,Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;

        parentMap.put(root, parent);
        buildParentMap(root.left, root, parentMap);
        buildParentMap(root.right, root, parentMap);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // Map to store parent of each node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        // BFS from target
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // If we reached distance k, collect result
            if (distance == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            // Expand current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }

                // right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }

                // parent
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }
}