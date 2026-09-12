class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;

        int cnt=0;
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - goal)) {
                cnt += map.get(prefixSum - goal);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return cnt;
    }
}