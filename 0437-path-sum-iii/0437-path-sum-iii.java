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
    // countPaths(node): paths from current node + paths from left subtree + paths from right subtree
    // using long targetSum in countPaths function because node.val range is -10^9 <= Node.val <= 10^9
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null) return 0;

        int current = countPaths(root, targetSum);

        int left = pathSum(root.left, targetSum);

        int right = pathSum(root.right, targetSum);

        return current + left + right;
    }

    public int countPaths(TreeNode node, long targetSum) {

        if(node == null) return 0;

        int count = 0;

        if(node.val == targetSum){
            count++;
        }
            
        count += countPaths(node.left, targetSum - node.val);
        count += countPaths(node.right, targetSum - node.val);

        return count;
    }
}