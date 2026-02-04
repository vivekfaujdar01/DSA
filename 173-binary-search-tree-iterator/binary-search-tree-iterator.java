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
class BSTIterator {
    // we are using stack that will store only first left side of tree
    // for next function we will pop top of stack and store left of right tree into the stack.
    // in hasNext we will just check stack is empty or not
    // for understanding we can thought about inorder traversal left->root->right we first add only left in stack while backtrack we will add right 
    
    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.val; 
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    void pushAll(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */