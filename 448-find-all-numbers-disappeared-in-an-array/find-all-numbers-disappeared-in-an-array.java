class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        for(int i=1;i<nums.length+1;i++){
            if(freq[i] == 0){
                arr.add(i);
            }
        }
        return arr;
    }
}