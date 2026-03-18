class Solution {
    // Negative Marking approach
    public List<Integer> findDuplicates(int[] arr) {
        // convert value to index (1-based to 0-based)
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]) - 1;

            // if already visited, it's a duplicate
            if (arr[idx] < 0) {
                ans.add(Math.abs(arr[i]));
            } else {
                
                // mark as visited
                arr[idx] = -arr[idx]; 
            }
        }

        return ans;
    }
}