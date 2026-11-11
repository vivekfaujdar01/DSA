class Solution {
    public int findLength(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int length = 0;

                int x = i;
                int y = j;

                while (x < n && y < m && nums1[x] == nums2[y]) {

                    length++;

                    maxLength = Math.max(maxLength, length);

                    x++;
                    y++;
                }
            }
        }

        return maxLength;
    }
}
