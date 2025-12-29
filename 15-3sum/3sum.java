class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // (Sorting + two pointer) Approach
        // Sort the array
        // Loop i from 0 to n-3
        // If nums[i] > 0, stop (because remaining numbers are positive)
        // Skip duplicate values of nums[i]
        // Use two pointers:
        // left = i + 1
        // right = n - 1
        // While left < right:
        // Compute sum = nums[i] + nums[left] + nums[right]
        // If sum == 0:
        // Add triplet
        // Move pointers and skip duplicates
        // If sum < 0: move left
        // If sum > 0: move right

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // If the current number is > 0, no possible triplet
            if (nums[i] > 0) break;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate second & third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
