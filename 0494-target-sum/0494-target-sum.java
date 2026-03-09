class Solution {
    // tabualtion approach
    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;
        for(int num : nums)
            totalSum += num;

        if((target + totalSum) % 2 != 0 || Math.abs(target) > totalSum){
            return 0;
        }       

        int S = (target + totalSum) / 2;

        int n = nums.length;

        int[][] dp = new int[n][S + 1];

        // Base cases
        if(nums[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
        }   

        if(nums[0] != 0 && nums[0] <= S){
            dp[0][nums[0]] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= S; j++) {

                int notTake = dp[i-1][j];
                int take = 0;
                if(nums[i] <= j){
                    take = dp[i-1][j - nums[i]];
                }

                dp[i][j] = take + notTake;
            }
        }

        return dp[n-1][S];
    }
}