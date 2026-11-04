class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;
        int count = 0;

        // Generate all possible subarrays
        for (int i = 0; i < n; i++) {

            for (int j = i + 2; j < n; j++) {

                // Check whether current subarray is arithmetic
                int diff = nums[i + 1] - nums[i];

                boolean isArithmetic = true;

                for (int k = i + 2; k <= j; k++) {

                    if (nums[k] - nums[k - 1] != diff) {
                        isArithmetic = false;
                        break;
                    }
                }

                if (isArithmetic) {
                    count++;
                }
            }
        }

        return count;
    }
}
