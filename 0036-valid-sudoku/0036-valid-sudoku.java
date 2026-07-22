class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check all rows
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];

                if (ch == '.') {
                    continue;
                }

                if (set.contains(ch)) {
                    return false;
                }

                set.add(ch);
            }
        }

        // Check all columns
        for (int col = 0; col < 9; col++) {
            HashSet<Character> set = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];

                if (ch == '.') {
                    continue;
                }

                if (set.contains(ch)) {
                    return false;
                }

                set.add(ch);
            }
        }

        // Check every 3x3 box
        for (int startRow = 0; startRow < 9; startRow += 3) {

            for (int startCol = 0; startCol < 9; startCol += 3) {

                HashSet<Character> set = new HashSet<>();

                for (int row = startRow; row < startRow + 3; row++) {

                    for (int col = startCol; col < startCol + 3; col++) {

                        char ch = board[row][col];

                        if (ch == '.') {
                            continue;
                        }

                        if (set.contains(ch)) {
                            return false;
                        }

                        set.add(ch);
                    }
                }
            }
        }

        return true;
    }
}