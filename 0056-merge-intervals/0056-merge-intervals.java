class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);  // Sort intervals by start time

        List<int[]> res = new ArrayList<>();

        // Traverse intervals
        for (int[] interval : intervals) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]) {
                res.add(interval);  // No overlap
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]); // Overlap -> merge
            }
        }
        
        int[][] ans = new int[res.size()][2];   // return res.toArray(new int[res.size()][]);

        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}