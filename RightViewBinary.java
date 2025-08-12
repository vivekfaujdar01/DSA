//LeetCode 199. Binary Tree Right Side View
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class RightViewBinary {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                if (i == size - 1) result.add(current.val);
            }
        }
        return result;
    }
    // Helper method to build a tree from array (for testing)
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode curr = queue.poll();
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        RightViewBinary r = new RightViewBinary();
        // Example 1: [1,2,3,null,5,null,4]
        Integer[] arr1 = {1,2,3,null,5,null,4};
        TreeNode root1 = buildTree(arr1);
        System.out.println(r.rightSideView(root1)); // Output: [1, 3, 4]

        // Example 2: [1,2,3,4,null,null,null,5]
        Integer[] arr2 = {1,2,3,4,null,null,null,5};
        TreeNode root2 = buildTree(arr2);
        System.out.println(r.rightSideView(root2)); // Output: [1, 3, 4, 5]

        // Example 3: [1,null,3]
        Integer[] arr3 = {1,null,3};
        TreeNode root3 = buildTree(arr3);
        System.out.println(r.rightSideView(root3)); // Output: [1, 3]

        // Example 4: []
        Integer[] arr4 = {};
        TreeNode root4 = buildTree(arr4);
        System.out.println(r.rightSideView(root4)); // Output: []
    }
}