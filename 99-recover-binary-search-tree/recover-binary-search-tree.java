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
    // Brute: O(n)+O(nlogn) (because of sorting) we can also do this by storing inorder traversal in array and we will sort it and then check swapping node and by finding them we will swap them

    // O(n) time complexitty, space complexity - O(h), h = height of tree
    // while traversing inorder: Current value should always be greater than previous
    // If it’s not -> something is wrong
    // there are two cases :
    // Case 1: Non-adjacent swap = at this time there will be two violations
    // Case 2: Adjacent swap = at this time there will be only one violation

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode sec = null;
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            sec = root;
        }

        prev = root;

        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;
    }
}