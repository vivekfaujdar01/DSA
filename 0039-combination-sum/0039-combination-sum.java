class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int index, int[] arr, int target, List<Integer> temp, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (index == arr.length) {
            return;
        }

        // PICK
        if (arr[index] <= target) {

            temp.add(arr[index]);

            solve(index, arr, target - arr[index], temp, ans); // stay at same index

            temp.remove(temp.size() - 1);
        }

        solve(index + 1, arr, target, temp, ans); // NON PICK
    }
}