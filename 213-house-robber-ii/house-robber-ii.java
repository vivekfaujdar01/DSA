class Solution {
    // in this method code logic is just we make two separate array without first element and last element 
    // and all other is same as house robber 1st
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] temp1 = new int[nums.length-1];
        int[] temp2 = new int[nums.length-1];
        int j = 0 , k = 0;
        for(int i=0; i<nums.length; i++){
            if(i != 0){
                temp1[j++] = nums[i];
            }    

            if(i != nums.length - 1){
                temp2[k++] = nums[i];
            }    
        }

        return Math.max(maximumSumOfNonAdjacent(temp1), maximumSumOfNonAdjacent(temp2));
    }
    
    public int maximumSumOfNonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int neg = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick += dp[i-2];
            }
            // pick = nums[i] + dp[i-2] upper code is same like this we just handle negative index case
            int notpick = 0 + dp[i-1];

            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}