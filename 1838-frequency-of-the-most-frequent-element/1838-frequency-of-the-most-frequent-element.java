class Solution {
    // We maintain a window [l -> r] such that: nums[r] * (window size) − sum ≤ k
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        long sum = 0;
        int maxFreq = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while ((long) nums[r] * (r - l + 1) - sum > k) {
                sum -= nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq, r - l + 1);
        }

        return maxFreq;
    }
}