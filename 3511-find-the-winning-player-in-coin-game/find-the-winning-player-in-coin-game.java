class Solution {
    public String winningPlayer(int x, int y) {
        return Math.min(x, y / 4) % 2 == 1 ? "Alice" : "Bob";
    }
}