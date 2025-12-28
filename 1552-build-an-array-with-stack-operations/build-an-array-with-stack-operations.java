class Solution {
    public List<String> buildArray(int[] target, int n) {

        // Strategy to do this question 
        // Maintain an index i for target
        // For each number num from 1 to n:
        // Always Push
        // If num == target[i] → keep it (move to next target element)
        // Else → Pop (because it’s not part of target)
        // Stop early once we build the entire target

        int idx = 0;
        List<String> res = new ArrayList<>();
        for(int i=1;i<=n;i++){
            res.add("Push");
            if(i == target[idx]){
                idx++;
            }
            else{
                res.add("Pop");
            }
            if(idx == target.length){
                break;
            }
        }
        return res;
    }
}