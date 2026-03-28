class Solution {
    // If it is rotated, there will be exactly one violation like prev element is greater due to the rotation point
    // If it is sorted then there will be no such violation
    // otherwise array cannot be sorted and rotated
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
}