class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int[] even = new int[n];
        int[] odd = new int[n];
        int j=0;

        for(int i=0;i<n;i++){
            even[i] = nums[i];
        }

        for(int i=n;i<2*n;i++){
            odd[i-n] = nums[i];
        }
        j=0;
        for(int i=0;i<n;i++){
            res[j++] = even[i];
            res[j++] = odd[i];
        }

        return res;
    }
}