class Solution {
    public int maxPower(String s) {
        int curr = 1;
        int maxcurr = curr;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                curr++;
                maxcurr = Math.max(curr, maxcurr);
            }
            else{
                curr = 1;
            }
        }

        return maxcurr;
    }
}