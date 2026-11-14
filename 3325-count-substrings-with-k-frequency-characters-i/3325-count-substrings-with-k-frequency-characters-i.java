class Solution {
    // Sliding Window
    public int numberOfSubstrings(String s, int k) {

        int n = s.length();

        int[] freq = new int[26];

        int left = 0;
        int count = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            int index = s.charAt(right) - 'a';

            freq[index]++;

            if (freq[index] == k) {
                count++;
            }

            while (count > 0) {

                ans += n - right;

                int leftIndex = s.charAt(left) - 'a';

                if (freq[leftIndex] == k) {
                    count--;
                }

                freq[leftIndex]--;
                left++;
            }
        }

        return ans;
    }
}