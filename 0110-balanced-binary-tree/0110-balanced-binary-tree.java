class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        if (left == -1)
            return -1;

        int right = height(root.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
}

// public boolean isBalanced(TreeNode root) {
//     if (root == null)
//         return true;

//     Queue<TreeNode> q = new LinkedList<>();
//     q.offer(root);

//     while (!q.isEmpty()) {
//         TreeNode node = q.poll();

//         int leftHeight = height(node.left);
//         int rightHeight = height(node.right);

//         if (Math.abs(leftHeight - rightHeight) > 1) {
//             return false;
//         }

//         if (node.left != null)
//             q.offer(node.left);
//         if (node.right != null)
//             q.offer(node.right);
//     }

//     return true;
// }

// public int height(TreeNode root) {
//     if (root == null)
//         return 0;
//     return 1 + Math.max(height(root.left), height(root.right));
// }