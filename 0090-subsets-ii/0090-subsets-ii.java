class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        rec(0, nums);
        return ans;
    }

    void rec(int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        // PICK
        subset.add(nums[index]);
        rec(index + 1, nums);
        subset.remove(subset.size() - 1);

        // Skip duplicates before NOT PICK
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        // NOT PICK
        rec(index + 1, nums);
    }
}