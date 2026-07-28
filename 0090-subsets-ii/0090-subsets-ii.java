class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums);
        return result;
    }

    void backtrack(int index, int[] nums) {
        // Store the current subset
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            // we don't start same recursion branch only if it is not the first index meand in backtrack(index) is not equal to i
            if (i > index && nums[i] == nums[i - 1]) continue; 

            // Choose
            subset.add(nums[i]);

            // Recurse
            backtrack(i + 1, nums);

            // Remove (Backtrack)
            subset.remove(subset.size() - 1);
        }
    }
}