class Solution {

    public boolean containsNearbyAlmostDuplicate(
        int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long current = nums[i];

            // Remove element outside the window
            if (i > indexDiff) {
                set.remove((long) nums[i - indexDiff - 1]);
            }

            // Find smallest element >= current - valueDiff
            Long candidate = set.ceiling(current - valueDiff);

            // Check whether candidate is within the range
            if (candidate != null &&
                candidate <= current + valueDiff) {
                return true;
            }

            // Add current element
            set.add(current);
        }

        return false;
    }
}
