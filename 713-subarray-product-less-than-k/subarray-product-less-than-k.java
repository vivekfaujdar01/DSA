class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Approach (Sliding approach)

        // Edge case
        if (k <= 1) return 0;

        int left = 0;
        long product = 1; // long to avoid overflow
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // Shrink window if product >= k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // Count valid subarrays ending at right
            count += (right - left + 1);
        }

        return count;
    }
}
