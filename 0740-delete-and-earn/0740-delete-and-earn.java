class Solution {
    // every index in points array tells that the total earning of an element from nums
    // nums = [2,2,3,3,3,4]
    // Index:   0  1  2  3  4
    // Points:  0  0  4  9  4
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];

        for(int num : nums){
            points[num] += num;
        }

        // Apply House Robber DP on points
        int n = points.length;
        int[] dp = new int[n];

        dp[0] = points[0];

        for(int i = 1; i < n; i++){
            int pick = points[i];
            if(i > 1){
                pick += dp[i-2];
            }

            int notpick = dp[i-1];

            dp[i] = Math.max(pick, notpick);
        }

        return dp[n-1];
    }
}