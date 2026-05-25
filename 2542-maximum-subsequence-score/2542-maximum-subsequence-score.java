class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int[][] pairs = new int[n][2]; // pair -> {nums2, nums1}

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]); // Sort by nums2 descending

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min heap for nums1 values

        long sum = 0;
        long ans = 0;

        for (int[] pair : pairs) {

            int currNums2 = pair[0];
            int currNums1 = pair[1];

            minHeap.offer(currNums1);
            sum += currNums1;

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                long score = sum * currNums2;
                ans = Math.max(ans, score);
            }
        }

        return ans;
    }
}