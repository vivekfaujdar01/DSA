class Solution {
    // if (i + j) is even -> go UP
    // else -> go DOWN
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] res = new int[n * m];
        int r = 0, c = 0;

        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];

            if ((r + c) % 2 == 0) { // moving up
                if (c == m - 1){
                    r++;
                }   
                else if (r == 0){
                    c++;
                }     
                else {
                    r--;
                    c++;
                }
            } else { // moving down
                if (r == n - 1){
                    c++;
                }
                else if (c == 0){
                    r++;
                } 
                else {
                    r++;
                    c--;
                }
            }
        }

        return res;
    }
}