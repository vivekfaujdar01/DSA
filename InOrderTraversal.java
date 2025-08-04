// LeetCode Q.94. Binary Tree Inorder Traversal
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Current must be null at this point
            current = stack.pop();
            result.add(current.val); // Add the node value to the result
            // Visit the right subtree
            current = current.right;
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InOrderTraversal solution = new InOrderTraversal();
        List<Integer> result = solution.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result); // Output: [4, 2, 5, 1, 3]
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) for the stack in the worst case
// Note: This solution uses an iterative approach with a stack to perform inorder traversal of a binary tree.
// Using a queue instead of a stack will not give correct inorder traversal.
// Queue (FIFO) is suitable for level-order (BFS), not inorder (DFS).
// Inorder requires LIFO order, which stack provides.
// If you use a queue, the traversal will be level-order, not inorder.
// Here is how it would look with a queue (for demonstration, but not correct for inorder):

/*
public List<Integer> inorderTraversal(TreeNode root) {
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

    return result; // This will return level-order traversal, not inorder
}*/