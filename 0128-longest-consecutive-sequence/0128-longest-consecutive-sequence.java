class Solution {
    // Using HashSet Time: O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
   
            if (!set.contains(num - 1)) { // Start only if it's the beginning of sequence

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}

// Using Sorting (Time Complexity: O(NlogN))
// public int longestConsecutive(int[] nums) {
//     Arrays.sort(nums);

//     int longest = 1;
//     int count = 1;

//     for (int i = 1; i < nums.length; i++) {
//         if (nums[i] == nums[i - 1] + 1) {
//             count++;
//         } else if (nums[i] != nums[i - 1]) {
//             count = 1;
//         }
//         longest = Math.max(longest, count);
//     }
// }