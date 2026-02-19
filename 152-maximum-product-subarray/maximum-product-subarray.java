class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDP = new int[n];
        int[] minDP = new int[n];
        
        // Base case
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        
        int result = nums[0];
        
        for (int i = 1; i < n; i++) {
            
            int curr = nums[i];
            
            maxDP[i] = Math.max(curr,Math.max(curr * maxDP[i - 1],curr * minDP[i - 1]));
            
            minDP[i] = Math.min(curr,Math.min(curr * maxDP[i - 1],curr * minDP[i - 1]));
            
            result = Math.max(result, maxDP[i]);
        }
        
        return result;
    }
}
