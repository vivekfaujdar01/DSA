class Solution {
    // same as Allocate Minimum Pages
    public int splitArray(int[] arr, int k) {
        int n = arr.length;

        // If students are more than books, allocation is impossible
        if (k > n) {
            return -1;
        }

        long low = 0;
        long high = 0;

        // Find the search space
        for (int pages : arr) {
            low = Math.max(low, pages); // Maximum single book
            high += pages;              // Sum of all pages
        }

        long ans = -1;

        // Binary Search on Answer
        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                ans = mid;
                high = mid - 1;   // Try to minimize the answer
            } else {
                low = mid + 1;    // Increase the limit
            }
        }

        return (int)ans;
    }
    // Returns true if allocation is possible with maxPages limit
    private boolean canAllocate(int[] arr, int k, long maxPages) {

        int students = 1;
        long currentPages = 0;

        for (int pages : arr) {

            // Current student can take this book
            if (currentPages + pages <= maxPages) {
                currentPages += pages;
            }
            // Need a new student
            else {
                students++;
                currentPages = pages;

                // More students required than available
                if (students > k) {
                    return false;
                }
            }
        }

        return true;
    }
}