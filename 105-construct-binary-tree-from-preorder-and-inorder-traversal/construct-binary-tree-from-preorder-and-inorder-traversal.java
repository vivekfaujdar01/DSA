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
    // I use preorder to pick roots sequentially and inorder to determine subtree boundaries. A HashMap helps me locate root positions in O(1).
    // Preorder -> gives root, Root -> Left -> Right
    // Inorder -> splits left & right, Left -> Root -> Right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd, Map<Integer, Integer> inorderMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inorderMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inorderMap);
        
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inorderMap);

        return root;
    }
}