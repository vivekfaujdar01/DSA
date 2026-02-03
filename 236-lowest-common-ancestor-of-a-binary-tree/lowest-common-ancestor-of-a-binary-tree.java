/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if we found root is null or if we found any node p or q then return that node 
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null){
            return right; // if left is null then return right node
        } 
        else if(right == null){
            return left; // if left is null then return left node
        }   
        else{
            return root;    // if both node is null then we found our result return that ndoe
        }
    }
}