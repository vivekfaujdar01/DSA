class Solution {
    public int mostFrequentEven(int[] nums) {
        int arr[] = new int[100001];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                arr[nums[i]]++;
            }
            
        }
        int ans = -1;
        int maxFrequency = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxFrequency){
                maxFrequency = arr[i];
                ans = i;
            }
            // if(maxFrequency==arr[i] && i<ans){
            //     ans = i;
            // }
        }
        return ans;
    }
}