/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // POSTORDER (Left -> Right -> Node)
    // Each node returns 4 values:
    // (isBST, sum, minValue, maxValue)
    // We also maintain a global variable: maxSum = 0
    // This question's thought process is similar to finding largest bst in binary tree

    // Global variable to track maximum BST sum
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    // Helper class to store subtree information
    private static class Info {
        boolean isBST;
        int sum;
        int min;
        int max;

        Info(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    // Postorder DFS
    private Info dfs(TreeNode node) {

        // Base case: empty tree is a valid BST
        if (node == null) {
            return new Info(
                true,                // isBST
                0,                   // sum
                Integer.MAX_VALUE,   // min
                Integer.MIN_VALUE    // max
            );
        }

        // Get info from left and right subtrees
        Info left = dfs(node.left);
        Info right = dfs(node.right);

        // Check BST validity at current node
        if (left.isBST && right.isBST &&
            node.val > left.max && node.val < right.min) {

            int currSum = left.sum + right.sum + node.val;

            // Update global maximum
            maxSum = Math.max(maxSum, currSum);

            int currMin = Math.min(left.min, node.val);
            int currMax = Math.max(right.max, node.val);

            return new Info(true, currSum, currMin, currMax);
        }

        // If not a BST, return invalid info
        return new Info(
            false,
            0,
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
        );
    }
}
