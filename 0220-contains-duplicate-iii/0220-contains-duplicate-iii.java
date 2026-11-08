// Using Bucketization and using hashmap to create buckets 
class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        Map<Long, Long> buckets = new HashMap<>();

        long bucketSize = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {

            long current = nums[i];

            // Calculate bucket ID
            long bucketId = Math.floorDiv(current, bucketSize);

            // Check the same bucket
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            // Check the left bucket
            if (buckets.containsKey(bucketId - 1)) {

                long candidate = buckets.get(bucketId - 1);

                if (Math.abs(current - candidate) <= valueDiff) {
                    return true;
                }
            }

            // Check the right bucket
            if (buckets.containsKey(bucketId + 1)) {

                long candidate = buckets.get(bucketId + 1);

                if (Math.abs(current - candidate) <= valueDiff) {
                    return true;
                }
            }

            // Insert current element
            buckets.put(bucketId, current);

            // Remove element outside the window
            if (i >= indexDiff) {

                long old = nums[i - indexDiff];

                long oldBucketId = Math.floorDiv(old, bucketSize);

                buckets.remove(oldBucketId);
            }
        }

        return false;
    }
}
