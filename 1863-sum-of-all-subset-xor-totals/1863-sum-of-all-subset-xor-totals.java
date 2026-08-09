class Solution {

    public int subsetXORSum(int[] nums) {
        return solve(0, 0, nums);
    }

    int solve(int index, int xor, int[] nums) {
        // All elements have been processed
        if (index == nums.length) {
            return xor;
        }

        // Take the current element
        int take = solve( index + 1, xor ^ nums[index], nums );

        // Don't take the current element
        int notTake = solve(index + 1, xor, nums);

        return take + notTake;
    }
}