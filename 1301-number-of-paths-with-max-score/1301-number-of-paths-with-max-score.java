class Solution {

    int MOD = 1000000007;
    int NEG = -(int)1e9;

    class Pair {
        int score;
        int ways;

        Pair(int score, int ways) {
            this.score = score;
            this.ways = ways;
        }
    }

    int[][] maxScore;
    int[][] ways;
    boolean[][] visited;

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        maxScore = new int[n][n];
        ways = new int[n][n];
        visited = new boolean[n][n];

        Pair ans = solve(board, n - 1, n - 1);

        if (ans.score < 0)
            return new int[]{0, 0};

        return new int[]{ans.score, ans.ways};
    }

    private Pair solve(List<String> board, int i, int j) {

        int n = board.size();

        if (i < 0 || j < 0)
            return new Pair(NEG, 0);

        if (board.get(i).charAt(j) == 'X')
            return new Pair(NEG, 0);

        if (board.get(i).charAt(j) == 'E')
            return new Pair(0, 1);

        if (visited[i][j])
            return new Pair(maxScore[i][j], ways[i][j]);

        Pair up = solve(board, i - 1, j);
        Pair left = solve(board, i, j - 1);
        Pair diag = solve(board, i - 1, j - 1);

        int best = Math.max(up.score, Math.max(left.score, diag.score));

        if (best == NEG) {
            visited[i][j] = true;
            maxScore[i][j] = NEG;
            ways[i][j] = 0;
            return new Pair(NEG, 0);
        }

        long cnt = 0;

        if (up.score == best)
            cnt += up.ways;

        if (left.score == best)
            cnt += left.ways;

        if (diag.score == best)
            cnt += diag.ways;

        char ch = board.get(i).charAt(j);

        int value = 0;
        if (ch >= '1' && ch <= '9')
            value = ch - '0';

        maxScore[i][j] = best + value;
        ways[i][j] = (int)(cnt % MOD);
        visited[i][j] = true;

        return new Pair(maxScore[i][j], ways[i][j]);
    }
}