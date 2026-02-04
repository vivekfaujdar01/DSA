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
    // The first element is always the root
    // After root: All smaller values belong to the left subtree, All larger values belong to the right subtree
    // We use a stack to track ancestors whose right child is not yet assigned, and preorder ensures we always process root before subtrees.

    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);

            // Case 1: left child
            if (node.val < stack.peek().val) {
                stack.peek().left = node;
            }
            // Case 2: right child
            else {
                TreeNode parent = null;
                while (!stack.isEmpty() && stack.peek().val < node.val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }

            stack.push(node);
        }

        return root;
    }
}