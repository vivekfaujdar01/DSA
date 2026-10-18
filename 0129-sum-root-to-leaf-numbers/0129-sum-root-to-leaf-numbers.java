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
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        rec(root, 0);
        return sum;
    }

    void rec(TreeNode node, int num) {
        if (node == null) return;

        num = num * 10 + node.val;

        if (node.left == null && node.right == null) {
            sum += num;
        }

        rec(node.left, num);
        rec(node.right, num);
    }
}