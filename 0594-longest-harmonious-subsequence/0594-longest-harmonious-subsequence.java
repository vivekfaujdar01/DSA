// Hashmap Approach
class Solution {

    public int findLHS(int[] nums) {

        // Store frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find maximum harmonious subsequence
        int ans = 0;

        for (int num : map.keySet()) {

            // Check whether num + 1 exists
            if (map.containsKey(num + 1)) {

                int length = map.get(num) + map.get(num + 1);

                ans = Math.max(ans, length);
            }
        }

        return ans;
    }
}

// class Solution {

//     public int findLHS(int[] nums) {

//         Arrays.sort(nums);

//         int left = 0;
//         int ans = 0;

//         for (int right = 0; right < nums.length; right++) {

//             while (nums[right] - nums[left] > 1) {
//                 left++;
//             }

//             if (nums[right] - nums[left] == 1) {
//                 ans = Math.max(ans, right - left + 1);
//             }
//         }

//         return ans;
//     }
// }