class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                neg.add(nums[i]);
            }
            else{
                pos.add(nums[i]);
            }
        }

        int i = 0;
        int j = 0;
        int k=0;
        while(k<nums.length && i<pos.size() && j<neg.size()){
            nums[k] = pos.get(i);
            i++;
            k++;
            
            nums[k] = neg.get(j);
            j++;
            k++;
            
        }
        return nums;
    }
}