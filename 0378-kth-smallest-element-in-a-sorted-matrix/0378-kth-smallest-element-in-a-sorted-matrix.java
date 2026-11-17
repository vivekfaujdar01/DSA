class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {

            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countLessEqual(int[][] matrix, int mid) {

        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {

            if (matrix[row][col] <= mid) { // All elements above are also <= mid
                count += row + 1;
                col++;
            } else { // Current element and everything below in this column are not candidates
                row--;
            }
        }

        return count;
    }

}

// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {

//         int n = matrix.length;

//         // Min Heap: [value, row, col]
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

//         // Insert first element of every row
//         for (int i = 0; i < n; i++) {
//             pq.offer(new int[] { matrix[i][0], i, 0 });
//         }

//         int result = 0;

//         // Remove k smallest elements
//         for (int i = 0; i < k; i++) {

//             int[] curr = pq.poll();

//             int value = curr[0];
//             int row = curr[1];
//             int col = curr[2];

//             result = value;

//             // Insert next element from the same row
//             if (col + 1 < n) {
//                 pq.offer(new int[] { matrix[row][col + 1], row, col + 1 });
//             }
//         }

//         return result;
//     }
// }
