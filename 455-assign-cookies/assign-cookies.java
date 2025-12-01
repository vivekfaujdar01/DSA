class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int childIndex = g.length-1;
        int cookieIndex = s.length-1;
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(childIndex >=0 && cookieIndex >= 0){
            if(g[childIndex] <= s[cookieIndex]){
                res++;
                cookieIndex--;
            }
            childIndex--;
        }

        return res;
    }
}