class Solution {
    public int search(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = n - 1;
        int m = l + (r - l) / 2;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (arr[m] == k) return m;

            if (arr[m] < k) l = m + 1;

            else
                r = m - 1;
        }

        return -1;
    }
}