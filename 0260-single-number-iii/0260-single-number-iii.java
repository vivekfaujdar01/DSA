class Solution {
    public int[] singleNumber(int[] nums) {

        // XOR all numbers
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        // Find rightmost set bit
        int mask = xor & -xor;

        // Divide into two groups
        int a = 0;
        int b = 0;

        for (int num : nums) {

            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}