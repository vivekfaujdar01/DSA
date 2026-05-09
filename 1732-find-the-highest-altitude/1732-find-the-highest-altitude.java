class Solution {
    public int largestAltitude(int[] gain) {
        int[] prefixSum = new int[gain.length + 1];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<gain.length;i++){
            prefixSum[i+1] += prefixSum[i] + gain[i]; 
        }

        for(int i=0;i<prefixSum.length;i++){
            max = Math.max(max, prefixSum[i]);
        }

        return max;
    }
}