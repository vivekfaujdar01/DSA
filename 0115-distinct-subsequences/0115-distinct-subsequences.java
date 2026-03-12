class Solution {
    // space optimisation using prev and curr 
    // at the place of dp[i-1] put prev and at dp[i] put curr and then copy curr to prev and return prev[m]
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[] prev = new int[m + 1];
        prev[0] = 1;

        for(int i = 1; i <= n; i++){

            int[] curr = new int[m + 1];
            curr[0] = 1;

            for(int j = 1; j <= m; j++){

                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}