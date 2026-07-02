class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int top = 0, bottom = r - 1;

        // Find correct row number
        while (top <= bottom) {
            int mid = (top + bottom) / 2;

            if (target > matrix[mid][c - 1]) {
                top = mid + 1;
            } 
            else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } 
            else {
                return binarySearch(matrix[mid], target);
            }
        }

        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;

        // finding target in a row
        while (low <= high) {
            int mid = (low + high) / 2;

            if (row[mid] == target) return true;
            else if (row[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}