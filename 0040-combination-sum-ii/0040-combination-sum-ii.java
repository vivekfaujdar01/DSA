class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int index, int[] nums, int target,
            List<Integer> temp,
            List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (index == nums.length || target < 0)
            return;

        // PICK
        if (nums[index] <= target) {
            temp.add(nums[index]);
            solve(index + 1, nums, target - nums[index], temp, ans);
            temp.remove(temp.size() - 1);
        }

        // Skip duplicates before NOT PICK
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        // NOT PICK
        solve(index + 1, nums, target, temp, ans);
    }
}