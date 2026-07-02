class Solution {
    // in this we will counts the set bits at each place of all numbers, because only the single element leaves that set bit when we divide count by 3 
    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {

            int count = 0;

            for (int num : nums) {

                if (((num >> i) & 1) == 1)
                    count++;
            }

            if (count % 3 != 0)
                ans |= (1 << i);
        }

        return ans;
    }
}