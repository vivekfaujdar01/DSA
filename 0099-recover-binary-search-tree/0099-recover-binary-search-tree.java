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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode sec = null;
    TreeNode third = null;
    TreeNode fourth = null;
    int count = 0;

    public void recoverTree(TreeNode root) {
        validateBst(root);
        if (count == 1) {
            int temp = first.val;
            first.val = sec.val;
            sec.val = temp;
        } else if (count == 2) {
            int temp = first.val;
            first.val = fourth.val;
            fourth.val = temp;
        }
    }

    public void validateBst(TreeNode root) {
        if (root == null) {
            return;
        }
        validateBst(root.left);

        if (prev != null && prev.val >= root.val) {
            count++;
            if (first == null) {
                first = prev;
                sec = root;
            } else if (third == null) {
                third = prev;
                fourth = root;
            }
        }
        prev = root;

        validateBst(root.right);
    }
}