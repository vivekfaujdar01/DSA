// -1	Not calculated yet
// 0	Cannot reach the destination
// 1	Can reach the destination
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return canReach(n - 1, nums, dp);
    }

    private boolean canReach(int index, int[] nums, int[] dp) {
        // Base case: index 0 is reachable from the start
        if (index == 0) {
            return true;
        }

        // If already calculated, reuse the answer
        if (dp[index] != -1) {
            return dp[index] == 1;
        }

        // Try every previous index
        for (int prev = index - 1; prev >= 0; prev--) {
            if (prev + nums[prev] >= index) {
                if (canReach(prev, nums, dp)) {
                    dp[index] = 1;
                    return true;
                }
            }
        }

        // No previous reachable index can reach this index
        dp[index] = 0;
        return false;
    }
}

// class Solution {
//     public boolean canJump(int[] nums) {
//         return canReach(nums.length - 1, nums);
//     }

//     private boolean canReach(int index, int[] nums) {
//         // Base case: reached the destination
//         if (index == 0) {
//             return true;
//         }

//         // Try every previous index
//         for (int prev = index - 1; prev >= 0; prev--) {
//             if (prev + nums[prev] >= index) {
//                 if (canReach(prev, nums)) {
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// }
