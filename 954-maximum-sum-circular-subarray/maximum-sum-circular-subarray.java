class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int currMax = nums[0],currMin = nums[0], totalSum = nums[0],
        maxSum = nums[0] , minSum = nums[0];
        for(int i = 1; i < nums.length; i++){

            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(minSum, currMin);

            totalSum += nums[i];
        } 

        int circularSum = totalSum - minSum;
        int normalSum = maxSum;

        if(totalSum == minSum){
            return normalSum;
        }

        return Math.max(circularSum, normalSum);

        // Concept is simple for circularSum = totalSum - minSum 
        // if all numbers are negative then totaSum = minSum
        // At the end we will return max of circularSum and normalSum
    }
}