class Solution {
    // in this we have to give maximum absolute sum that can be actual minSum also or maxSum in array
    // approach is using kadane finding maxSum and minSum
    // as a result returning max absolute value
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0], currMax = nums[0], minSum = nums[0], currMin = nums[0];

        for(int i=1;i<nums.length;i++){
            currMax = Math.max(nums[i],currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);
        }

        maxSum = Math.abs(maxSum);
        minSum = Math.abs(minSum);

        return Math.max(maxSum, minSum);
    }
}