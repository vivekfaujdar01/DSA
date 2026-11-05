// Tabulation
class Solution {

    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        int count = 0;

        // Start from index 2
        for (int i = 2; i < n; i++) {

            // Check whether the last two differences are equal
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {

                dp[i] = dp[i - 1] + 1;

            } else {

                dp[i] = 0;
            }

            // Add slices ending at current index
            count += dp[i];
        }

        return count;
    }
}


// // Memoisation
// class Solution {

//     public int numberOfArithmeticSlices(int[] nums) {

//         int n = nums.length;

//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);

//         int count = 0;

//         for (int i = 2; i < n; i++) {
//             count += solve(nums, i, dp);
//         }

//         return count;
//     }

//     private int solve(int[] nums, int i, int[] dp) {

//         if (i < 2) {
//             return 0;
//         }

//         if (dp[i] != -1) {
//             return dp[i];
//         }

//         // Check consecutive differences
//         if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {

//             dp[i] = solve(nums, i - 1, dp) + 1;
//         } 
//         else {
//             dp[i] = 0;
//         }

//         return dp[i];
//     }
// }
