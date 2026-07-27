class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        rec(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    void rec(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Take
        current.add(nums[index]);
        rec(index + 1, nums, current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Don't Take
        rec(index + 1, nums, current, ans);
    }
}