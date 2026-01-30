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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Base case: empty tree
        if (root == null) {
            return false;
        }

        // If this is a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Reduce targetSum by current node's value
        int remainingSum = targetSum - root.val;

        // Recurse on left and right subtrees
        return hasPathSum(root.left, remainingSum) ||
               hasPathSum(root.right, remainingSum);
    }
}
