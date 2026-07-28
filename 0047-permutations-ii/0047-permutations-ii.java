class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        solve(nums, used, temp, ans);

        return ans;
    }
    void solve(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> ans) {

        // Base Case
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Try every unused element
        for (int i = 0; i < nums.length; i++) {

            if (used[i]) { 
                continue;
            }

            if(i>0 && nums[i] == nums[i-1] && !used[i - 1]){    
            // When Previous duplicate NOT used we will continue because previous value can lead to same output 
            // but if previous value is used then we will add it in result because this is different branch
                continue;
            }

            // Choose
            used[i] = true;
            temp.add(nums[i]);

            // Explore
            solve(nums, used, temp, ans);

            // Backtrack
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}