class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return result;
    }

    private void backtrack(int index, int[] nums) {
        // Store the current subset
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            // Choose
            subset.add(nums[i]);

            // Recurse
            backtrack(i + 1, nums);

            // Remove (Backtrack)
            subset.remove(subset.size() - 1);
        }
    }
}