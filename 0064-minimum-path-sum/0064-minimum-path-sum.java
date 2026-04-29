class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];

        for(int i = 0; i < n; i++){
            int[] curr = new int[m];

            for(int j = 0; j < m; j++){

                if(i == 0 && j == 0){
                    curr[j] = grid[i][j];
                }
                else{
                    int up = (i > 0) ? prev[j] : (int)1e5;
                    int left = (j > 0) ? curr[j-1] : (int)1e5;

                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }

            prev = curr; // move current row to previous
        }

        return prev[m-1];
    }
}