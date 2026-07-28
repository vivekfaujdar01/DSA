class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        rec(0, nums);
        return ans;
    }

    private void rec(int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        // PICK
        subset.add(nums[index]);
        rec(index + 1, nums);
        subset.remove(subset.size() - 1);

        // NOT PICK
        rec(index + 1, nums);
    }
}