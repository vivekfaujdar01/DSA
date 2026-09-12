// We can use Sliding window in this because sum will increase, and negative values are not allowed in this array.
// Something atmost logic is in another question of sliding window: https://leetcode.com/problems/subarrays-with-k-different-integers/description/
class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            // Number of valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}