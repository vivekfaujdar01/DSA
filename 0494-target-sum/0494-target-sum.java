class Solution {
    // recursion approach
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(n - 1, target, nums);
    }

    private int solve(int index, int target, int[] nums) {

        if(index == 0) {
            int ways = 0;

            if(target == nums[0]) ways++;
            if(target == -nums[0]) ways++;

            return ways;
        }

        int plus = solve(index - 1, target - nums[index], nums);

        int minus = solve(index - 1, target + nums[index], nums);

        return plus + minus;
    }
} 