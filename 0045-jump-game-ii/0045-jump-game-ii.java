class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n - 1, nums, dp);
    }

    private int solve(int index, int[] nums, int[] dp) {

        // Base case
        if (index == 0) {
            return 0;
        }

        // Already calculated
        if (dp[index] != -1) {
            return dp[index];
        }

        int minJumps = Integer.MAX_VALUE;

        // Check all previous indices that can reach index
        for (int prev = index - 1; prev >= 0; prev--) {

            if (prev + nums[prev] >= index) {
                int jumps = 1 + solve(prev, nums, dp);
                minJumps = Math.min(minJumps, jumps);
            }
        }

        return dp[index] = minJumps;
    }
}

// class Solution {
//     public int jump(int[] nums) {
//         int n = nums.length;

//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);

//         return solve(n - 1, nums, dp);
//     }

//     private int solve(int index, int[] nums, int[] dp) {

//         // Base case: destination reached
//         if (index == 0) {
//             return 0;
//         }

//         int minJumps = Integer.MAX_VALUE;

//         // Check all previous indices that can reach index
//         for (int prev = index - 1; prev >= 0; prev--) {

//             if (prev + nums[prev] >= index) {
//                 int jumps = 1 + solve(prev, nums);
//                 minJumps = Math.min(minJumps, jumps);
//             }
//         }

//         return minJumps;
//     }
// }