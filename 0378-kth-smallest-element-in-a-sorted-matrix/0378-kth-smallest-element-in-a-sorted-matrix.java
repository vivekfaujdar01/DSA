class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        // Min Heap: [value, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Insert first element of every row
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { matrix[i][0], i, 0 });
        }

        int result = 0;

        // Remove k smallest elements
        for (int i = 0; i < k; i++) {

            int[] curr = pq.poll();

            int value = curr[0];
            int row = curr[1];
            int col = curr[2];

            result = value;

            // Insert next element from the same row
            if (col + 1 < n) {
                pq.offer(new int[] { matrix[row][col + 1], row, col + 1 });
            }
        }

        return result;
    }
}
