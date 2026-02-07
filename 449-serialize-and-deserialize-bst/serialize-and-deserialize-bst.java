/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Codec {
    // Use Preorder Traversal
    // Root comes first
    // Next values tells whether they belong to left or right subtree using BST rules
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        int[] index = new int[1]; // acts as pointer
        return buildBST(values, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildBST(String[] values, int[] index, int min, int max) {
        if (index[0] >= values.length) return null;

        int val = Integer.parseInt(values[index[0]]);

        // Value must lie within valid BST range
        if (val < min || val > max) return null;

        TreeNode node = new TreeNode(val);
        index[0]++;

        node.left = buildBST(values, index, min, val);
        node.right = buildBST(values, index, val, max);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;