class Solution {
    public int repeatedNTimes(int[] nums) {
        // Because the repeated element appears many times,
        // it must appear next to itself at least once
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
