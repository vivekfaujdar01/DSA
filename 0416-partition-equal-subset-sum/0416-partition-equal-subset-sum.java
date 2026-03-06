class Solution {
    // tabulation approach to solve it
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums)  sum += num;

        if(sum % 2 != 0)  return false;

        int target = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n][target + 1];

        // sum 0 always possible
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        // first element
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i < n; i++) {
            for(int t = 1; t <= target; t++) {

                boolean notTake = dp[i-1][t];

                boolean take = false;
                if(nums[i] <= t){
                    take = dp[i-1][t - nums[i]];
                }

                dp[i][t] = take || notTake;
            }
        }

        return dp[n-1][target];
    }
}

    // memoisation approach to solve it
    // private boolean solve(int[] nums, int index, int target, int[][] dp) {
    //     if(target == 0)  return true;
    //     if(index == 0)  return nums[0] == target;
    //     if(dp[index][target] != -1)  return dp[index][target] == 1;
    //     boolean notTake = solve(nums, index - 1, target, dp);
    //     boolean take = false;
    //     if(nums[index] <= target){
    //         take = solve(nums, index - 1, target - nums[index], dp);
    //     }
    //     dp[index][target] = (take || notTake) ? 1 : 0;
    //     return dp[index][target] == 1;
    // }