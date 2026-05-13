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
    private int ans = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);   // pretend start left
        dfs(root, false, 0);  // pretend start right
        return ans;
    }

    private void dfs(TreeNode node, boolean goLeft, int length) {
        if (node == null) return;

        ans = Math.max(ans, length);    // update max

        if (goLeft) {
            dfs(node.left, false, length + 1);  // continue zigzag by going left (next turn will be right)  
            dfs(node.right, true, 1);   // restart fresh from right
        } else {
            dfs(node.right, true, length + 1);
            dfs(node.left, false, 1);
        }
    }
}