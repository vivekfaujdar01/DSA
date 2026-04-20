class Solution {
    // in this logic is based on kadane we keep minimum Sum and maximum sum in array 
    // because we know if we subtract the minSum from totalSum then remaining will be circular sum 
    // but there will be an edge case when all elements are negative then totalSum will become equal to minSum so we have to handle this
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

    }
}