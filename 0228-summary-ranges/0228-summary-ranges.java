class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();

        int i = 0;
        int n = nums.length;

        while (i < n) {

            int start = nums[i];

            while (i + 1 < n && (long) nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            int end = nums[i];

            if (start == end) {
                ans.add(String.valueOf(start));
            } else {
                ans.add(start + "->" + end);
            }

            i++;
        }

        return ans;
    }
}