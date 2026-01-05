class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Approach (prefix sums + modulo logic)
        // (prefixSum[r] - prefixSum[l-1]) % k == 0
        // prefixSum[r] % k == prefixSum[l-1] % k
        // mod = ((sum % k) + k) % k;

        // remainder -> frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // base case

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // normalize modulo
            int mod = ((sum % k) + k) % k;

            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
