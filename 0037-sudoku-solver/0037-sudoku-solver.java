class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for(int row = 0; row < 9; row++) {

            for(int col = 0; col < 9; col++) {

                if(board[row][col] == '.') {

                    for(char ch = '1'; ch <= '9'; ch++) {

                        if(isValid(board, row, col, ch)) {

                            board[row][col] = ch;

                            if(solve(board))
                                return true;

                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {

        // Check Row
        for(int c = 0; c < 9; c++) {
            if(board[row][c] == ch)
                return false;
        }

        // Check Column
        for(int r = 0; r < 9; r++) {
            if(board[r][col] == ch)
                return false;
        }

        // Check 3 x 3 Box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int r = startRow; r < startRow + 3; r++) {
            for(int c = startCol; c < startCol + 3; c++) {

                if(board[r][c] == ch)
                    return false;
            }
        }

        return true;
    }
}