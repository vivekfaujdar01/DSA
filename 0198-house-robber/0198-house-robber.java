class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        for(int i=0;i<n;i++){
            dp[i] = -1;
        }

        return rec(nums, n-1, dp);
    }
    public int rec(int[] nums, int n, int[] dp){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return nums[n];
        }

        if(dp[n] != -1) return dp[n];

        int pick = nums[n] + rec(nums, n-2, dp) ;
        int notpick = 0 + rec(nums, n-1, dp) ;

        return dp[n] = Math.max(pick, notpick);
    }
}