class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}

// public int diameterOfBinaryTree(TreeNode root) {
//     if (root == null)
//         return 0;

//     int leftHeight = height(root.left);
//     int rightHeight = height(root.right);

//     int currDiameter = leftHeight + rightHeight;

//     int leftDiameter = diameterOfBinaryTree(root.left);
//     int rightDiameter = diameterOfBinaryTree(root.right);

//     return Math.max(currDiameter, Math.max(leftDiameter, rightDiameter));
// }

// public int height(TreeNode root) {
//     if (root == null)
//         return 0;

//     int left = height(root.left);
//     int right = height(root.right);

//     return 1 + Math.max(left, right);
// }