// LeetCode Problem 145: PostOrderTraversal.java
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

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val); // Add to the front to reverse the order
            
            // Push left child first so that right child is processed first
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
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

        PostOrderTraversal solution = new PostOrderTraversal();
        List<Integer> result = solution.postorderTraversal(root);

        System.out.println("Postorder Traversal: " + result); // Output: [4, 5, 2, 3, 1]
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) for the stack in the worst case
// Note: This solution uses an iterative approach with a stack to perform postorder traversal of a binary tree.
// The result is built in reverse order by adding elements to the front of the list.
