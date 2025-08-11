
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MaxInBinaryTree {
    public int maxInBinaryTree(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = maxInBinaryTree(root.left);
        int rightMax = maxInBinaryTree(root.right);
        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    // static int findMax(Node node)
	// {
	// 	if (node == null)
	// 		return Integer.MIN_VALUE;

	// 	int res = node.val;
	// 	int lres = findMax(node.left);
	// 	int rres = findMax(node.right);

	// 	if (lres > res)
	// 		res = lres;
	// 	if (rres > res)
	// 		res = rres;
	// 	return res;
	// }

    public static void main(String[] args) {
        MaxInBinaryTree tree = new MaxInBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(tree.maxInBinaryTree(root));  // Output: 5
    }
}
