class Solution {
    // Instead of counting 0s and 1s separately: Convert 0 → -1
    // now it will become: Find the longest subarray with sum = 0.
    
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // important for subarray starting from index 0
        
        int sum = 0;
        int maxLength = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            // Convert 0 to -1
            if(nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }
            
            if(map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        
        return maxLength;
    }
}
