class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int startRow = startPos[0];
        int startCol = startPos[1];

        int homeRow = homePos[0];
        int homeCol = homePos[1];

        int cost = 0;

        // Move vertically
        if (startRow < homeRow) {
            for (int r = startRow + 1; r <= homeRow; r++) {
                cost += rowCosts[r];
            }
        } else {
            for (int r = startRow - 1; r >= homeRow; r--) {
                cost += rowCosts[r];
            }
        }

        // Move horizontally
        if (startCol < homeCol) {
            for (int c = startCol + 1; c <= homeCol; c++) {
                cost += colCosts[c];
            }
        } else {
            for (int c = startCol - 1; c >= homeCol; c--) {
                cost += colCosts[c];
            }
        }

        return cost;
    }
}