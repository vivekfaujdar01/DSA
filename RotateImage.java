//Leetcode Problem 48: Rotate Image
// This code rotates a given n x n 2D matrix (image) by 90 degrees clockwise.
// The rotation is done in-place, meaning the original matrix is modified directly without using additional space for another matrix.
public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // First, transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Then, reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ri.rotate(matrix);
        
        // Print the rotated matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}