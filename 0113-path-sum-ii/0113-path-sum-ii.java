class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();

        dfs(root, targetSum, 0, res, a);

        return res;
    }
    void dfs(TreeNode root, int targetSum,int sum,List<List<Integer>> res,List<Integer> a ){
        if(root==null){
            return;
        }

        sum +=root.val;

        a.add(root.val);

        if(root.left==null&&root.right==null && sum==targetSum){
            res.add(new ArrayList<>(a));
        }

        dfs(root.left, targetSum, sum, res, a);
        dfs(root.right, targetSum, sum, res, a);

        a.remove(a.size()-1);
    }
}