class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        // Optimise solution because in constraint range of numbers are from 0 to 100

        // Step 1: Count frequency
        for (int num : nums) {
            count[num]++;
        }

        // Step 2: Prefix sum
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build result
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                result[i] = 0;
            else
                result[i] = count[nums[i] - 1];
        }

        return result;
    }
}
