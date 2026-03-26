class Solution {
    // After sorting the array this question become same as Longest increasing subsequence 
    // for understanding LIS https://chatgpt.com/g/g-p-6909c7eccabc8191a018fcf393fc2d2f-dsa/c/69c3c7a7-3f0c-8322-b7cd-7726f3592877
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }

        for(int i = 0; i < n ; i++){
            parent[i] = i;
        }

        int maxLen = 1, lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {                   
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }

            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (parent[lastIndex] != lastIndex) {
            result.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        result.add(nums[lastIndex]);

        Collections.reverse(result);
        return result;
    }
}