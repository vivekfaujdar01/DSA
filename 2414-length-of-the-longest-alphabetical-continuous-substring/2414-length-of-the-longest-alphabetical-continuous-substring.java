class Solution {
    public int longestContinuousSubstring(String s) {
            int ans = 1 , count = 1;
            for(int i = 0; i< s.length() - 1 ; i++){
                if(s.charAt(i + 1) - s.charAt(i) == 1){ 
                    count++;
                    ans = Math.max(ans,count);
                }
                else count = 1;
            }

            return ans;
    }
}