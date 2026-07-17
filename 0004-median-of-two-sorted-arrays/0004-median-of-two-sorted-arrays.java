class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;

        int i = 0;
        int j = 0;

        int count = -1;
        int prev = 0;
        int curr = 0;

        while (i < m && j < n) {

            prev = curr;

            if (nums1[i] <= nums2[j]) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }

            count++;

            if (count == total / 2) break;

        }

        while (count < total / 2 && i < m) {
            prev = curr;
            curr = nums1[i++];
            count++;
        }

        while (count < total / 2 && j < n) {
            prev = curr;
            curr = nums2[j++];
            count++;
        }

        if (total % 2 == 1)
            return curr;

        return (prev + curr) / 2.0;
    }
}