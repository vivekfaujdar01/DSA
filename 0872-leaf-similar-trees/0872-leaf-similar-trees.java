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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();

        leafValues(root1, leaf1);
        leafValues(root2, leaf2);

        return leaf1.equals(leaf2);
    }

    public void leafValues(TreeNode root, ArrayList<Integer> leaf){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leaf.add(root.val);
        }

        leafValues(root.left, leaf);
        leafValues(root.right, leaf);
    }
}