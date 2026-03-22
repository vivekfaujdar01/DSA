class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if (intervals.length == 0) return 0;    // Edge case

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0; // number of removals
        int prevEnd = intervals[0][1];

        // Traverse intervals
        for (int i = 1; i < intervals.length; i++) {
            // Overlapping case
            if (intervals[i][0] < prevEnd) {
                count++; // remove this interval
            } else {
                // Non-overlapping -> update prevEnd
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}