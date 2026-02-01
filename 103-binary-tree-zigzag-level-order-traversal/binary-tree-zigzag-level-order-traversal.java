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
    // Solution is same as bfs traversal
    // just one trick i use a variable to track level if level is even add node value in last in array 
    // if level is odd add value in front of array
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) return list;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;  // start from level 0

    while (!queue.isEmpty()) {
        int n = queue.size();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            TreeNode curr = queue.poll();

            // zigzag insertion
            if (level % 2 == 0) {
                arr.add(curr.val);          // left to right
            } else {
                arr.add(0, curr.val);       // right to left
            }

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        list.add(arr);
        level++;
    }

    return list;
}
}