class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SizeOfBinary {
    public int sizeOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return 1 + sizeOfBinaryTree(root.left) + sizeOfBinaryTree(root.right);
    }
    public static void main(String[] args) {
        SizeOfBinary tree = new SizeOfBinary();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(tree.sizeOfBinaryTree(root));  // Output: 5
    }
}
