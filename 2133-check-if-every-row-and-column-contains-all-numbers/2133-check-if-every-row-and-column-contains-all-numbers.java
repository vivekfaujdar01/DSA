class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) { // Check every row

            boolean[] visited = new boolean[n + 1];

            for (int j = 0; j < n; j++) {

                int num = matrix[i][j];

                if (visited[num]) {
                    return false;
                }

                visited[num] = true;
            }
        }

        for (int j = 0; j < n; j++) { // Check every column

            boolean[] visited = new boolean[n + 1];

            for (int i = 0; i < n; i++) {

                int num = matrix[i][j];

                if (visited[num]) {
                    return false;
                }

                visited[num] = true;
            }
        }

        return true;
    }
}