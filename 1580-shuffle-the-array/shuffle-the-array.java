class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int x = 0;
        int y = n;
        
        for(int i=0;i<nums.length;i+=2){
            res[i] = nums[x];
            res[i+1] = nums[y];
            x++;
            y++;
        }

        return res;
    }
}