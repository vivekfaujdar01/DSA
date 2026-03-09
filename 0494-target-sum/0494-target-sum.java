class Solution {
    // converting this question to partition into two subsets whose difference equal to target
    // recursion approach
    // sum(P) - sum(N) = target
    // sum(P) + sum(N) = totalSum
    // 2 * sum(P) = target + totalSum
    // sum(P) = (target + totalSum) / 2
    // 416. Partition Equal Subset Sum once check this to understand more this almost similar
    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }    

        if((target + totalSum) % 2 != 0 || Math.abs(target) > totalSum){
            return 0;
        }         

        int s = (target + totalSum) / 2;

        return countSubsets(nums.length - 1, s, nums);
    }

    private int countSubsets(int index, int sum, int[] nums) {

        if(index == 0) {
            if(sum == 0 && nums[0] == 0){
                return 2;
            }
            if(sum == 0 || sum == nums[0]){
                return 1;
            }
            return 0;
        }

        int notTake = countSubsets(index - 1, sum, nums);

        int take = 0;
        if(nums[index] <= sum){
            take = countSubsets(index - 1, sum - nums[index], nums);
        }
            
        return take + notTake;
    }
}