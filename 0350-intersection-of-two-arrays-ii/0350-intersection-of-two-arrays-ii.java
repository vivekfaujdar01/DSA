class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x : nums1){
            arr.add(x);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int x : nums2){
            if(arr.contains(x)){
                list.add(x);
                arr.remove(Integer.valueOf(x));
            }
        }
        int []res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}