class Solution {
    // top down
    static final int MOD = 1000000007;
    Long[] full;
    Long[] gap;

    public int numTilings(int n) {
        full = new Long[n + 1];
        gap = new Long[n + 1];
        return (int)solveFull(n);
    }

    long solveFull(int n) {

        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n < 0) return 0;

        if (full[n] != null) return full[n];

        long ans = 0;

        ans += solveFull(n - 1);// one vertical

        ans += solveFull(n - 2);// two horizontal

        ans += 2L * solveGap(n - 1);

        return full[n] = (ans % MOD);
    }

    long solveGap(int n) {

        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;

        if (gap[n] != null) return gap[n];

        long ans = 0;

        ans += solveGap(n - 1);// adding one horizontal to that gap

        ans += solveFull(n - 2);// adding tomino that will the gap

        return gap[n] = (ans % MOD);
    }
}