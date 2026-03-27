class Solution {
    // We maintain two arrays:
    // len[i] : Length of LIS ending at index i
    // count[i] : Number of LIS ending at index i
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] len = new int[n];     // length of LIS
        int[] count = new int[n];   // number of LIS

        // Initialize
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            count[i] = 1;
        }

        int maxLen = 1;

        // DP
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {

                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];  // reset count
                    } 
                    else if (len[j] + 1 == len[i]) {
                        count[i] += count[j]; // add ways
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }

        // Count total LIS
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                result += count[i];
            }
        }

        return result;
    }
}