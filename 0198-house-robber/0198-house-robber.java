class Solution {
    public int rob(int[] arr) {
        int n = arr.length;

        int prev = arr[0]; // dp[i-1]
        int prev2 = 0; // dp[i-2]

        for (int i = 1; i < n; i++) {
            int pick = arr[i] + prev2;
            int notPick = prev;

            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}

// class Solution {
//     // Tabulation method
//     // we handle this question by picking an element and notpicking then we take max of that.
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         int neg = 0;
//         for (int i = 1; i < n; i++) {
//             int pick = nums[i];
//             if (i > 1) {
//                 pick += dp[i - 2];
//             }
//             // pick = nums[i] + dp[i-2] upper code is same like this we just handle negative index case
//             int notpick = 0 + dp[i - 1];

//             dp[i] = Math.max(pick, notpick);
//         }
//         return dp[n - 1];
//     }
// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int dp[] = new int[n];

//         for(int i=0;i<n;i++){
//             dp[i] = -1;
//         }

//         return rec(nums, n-1, dp);
//     }
//     public int rec(int[] nums, int n, int[] dp){
//         if(n < 0){
//             return 0;
//         }
//         if(n == 0){
//             return nums[n];
//         }

//         if(dp[n] != -1) return dp[n];

//         int pick = nums[n] + rec(nums, n-2, dp) ;
//         int notpick = 0 + rec(nums, n-1, dp) ;

//         return dp[n] = Math.max(pick, notpick);
//     }
// }