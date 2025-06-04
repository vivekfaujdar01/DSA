import java.util.*;

public class LCSOf_3_Strings {
    static int findLCSOf3(String s1, String s2, String s3, int i, int j, int k, int[][][] memo) {

        // Base case: If any of the strings is empty
        if (i >= s1.length() || j >= s2.length() || k >= s3.length())
            return 0;

        // If the result is already computed, return it from
        // the memo table
        // recursive case
        if (memo[i][j][k] != -1)
            return memo[i][j][k];

        // If the last characters of s1, s2, and s3 are the
        // same
        if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k))
            return memo[i][j][k] = 1 + findLCSOf3(s1, s2, s3, i + 1, j + 1, k + 1, memo);

        // If last characters do not match, calculate LCS by excluding one string at a
        // time
        return memo[i][j][k] = Math.max(
                Math.max(findLCSOf3(s1, s2, s3, i + 1, j, k, memo), findLCSOf3(s1, s2, s3, i, j + 1, k, memo)),
                findLCSOf3(s1, s2, s3, i, j, k + 1, memo));
    }

    static int lcsOf3(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        // Initialize the memo table with -1
        int[][][] memo = new int[n1 + 1][n2 + 1][n3 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return findLCSOf3(s1, s2, s3, 0, 0, 0, memo);
    }

    public static void main(String[] args) {
        String s1 = "AGGT12";
        String s2 = "12TXAYB";
        String s3 = "12XBA";
        int res = lcsOf3(s1, s2, s3);
        System.out.print(res);
    }
}
