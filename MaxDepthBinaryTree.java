// LeetCode Problem 104: Maximum Depth of Binary Tree
import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }

    // Alternatively, you can use recursion
    // public int maxDepth(TreeNode root) {
    //     if(root == null){
    //         return 0;
    //     }
    //     return Math.max( maxDepth(root.left), maxDepth(root.right) ) + 1;
    // }
    
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxDepthBinaryTree solution = new MaxDepthBinaryTree();
        int result = solution.maxDepth(root);

        System.out.println("Maximum Depth: " + result); // Output: 3
    }
}

// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(n) for the queue in the worst case   
// Note: This solution uses a breadth-first search (BFS) approach to find the maximum depth of a binary tree.