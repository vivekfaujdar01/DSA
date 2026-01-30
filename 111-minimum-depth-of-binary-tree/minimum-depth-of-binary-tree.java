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
    // (I wrote both BFS and DFS code)
    // This one is BFS

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // process one level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // leaf found → answer
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    
    // This one is with dfs
    // public int minDepth(TreeNode root) {
    //     // Case 1: empty tree
    //     if (root == null) return 0;

    //     // Case 2: leaf node
    //     if (root.left == null && root.right == null) {
    //         return 1;
    //     }

    //     // Case 3: one child is missing
    //     if (root.left == null) {
    //         return 1 + minDepth(root.right);
    //     }
    //     if (root.right == null) {
    //         return 1 + minDepth(root.left);
    //     }

    //     // Case 4: both children exist
    //     return 1 + Math.min(
    //         minDepth(root.left),
    //         minDepth(root.right)
    //     );
    //     // if(root == null){
    //     //     return 0;
    //     // }
    //     // int leftDepth = minDepth(root.left);
    //     // int rightDepth = minDepth(root.right);
    //     // if(leftDepth == 0 || rightDepth == 0){
    //     //     return leftDepth + rightDepth + 1;
    //     // }
    //     // return Math.min( leftDepth, rightDepth ) + 1;
    // }
}