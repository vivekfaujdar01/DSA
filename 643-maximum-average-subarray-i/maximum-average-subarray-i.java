class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double prefixSum = 0;
        double ans = 0;

        for (int i = 0; i < k; i++) {
            prefixSum += nums[i];
        }
        ans = prefixSum / k;

        for (int i = k; i < nums.length; i++) {
            prefixSum += nums[i] - nums[i - k];
            ans = Math.max(ans, prefixSum / k);
        }
        return ans;
    }
}