// LeetCode 144. Binary Tree Preorder Traversal
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            
            // Push right child first so that left child is processed first
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        PreOrderTraversal solution = new PreOrderTraversal();
        List<Integer> result = solution.preorderTraversal(root);
        
        System.out.println("Preorder Traversal: " + result); // Output: [1, 2, 3]
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) for the stack in the worst case
// Note: This solution uses an iterative approach with a stack to perform preorder traversal of a binary tree.
// Using a queue instead of a stack will not give correct preorder traversal.
    // Queue (FIFO) is suitable for level-order (BFS), not preorder (DFS).
    // Preorder requires LIFO order, which stack provides.
    // If you use a queue, the traversal will be level-order, not preorder.
    // Here is how it would look with a queue (for demonstration, but not correct for preorder):

    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            // For queue, left child is added before right child
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result; // This will return level-order traversal, not preorder
    }
    */