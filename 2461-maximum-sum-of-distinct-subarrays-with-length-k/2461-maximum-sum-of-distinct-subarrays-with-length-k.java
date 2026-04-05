class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long windowSum = 0, maxSum = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            if (r - l + 1 > k) {
                windowSum -= nums[l];
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0) {
                    freq.remove(nums[l]);
                }
                l++;
            }

            if (r - l + 1 == k && freq.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}