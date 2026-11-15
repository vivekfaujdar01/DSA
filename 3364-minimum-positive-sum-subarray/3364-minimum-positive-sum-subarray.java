class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {

                int len = j - i + 1;

                if (len >= l && len <= r) {

                    int sum = prefix[j + 1] - prefix[i];

                    if (sum > 0) {
                        ans = Math.min(ans, sum);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
