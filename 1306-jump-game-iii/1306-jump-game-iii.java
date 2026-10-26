// Without tracking visited indices, recursion can repeat forever. We need a way to recognize that we've already explored an index.

class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        return solve(arr, start, visited);
    }

    private boolean solve(int[] arr, int start, boolean[] visited) {

        // Base case: reached a zero
        if (arr[start] == 0) {
            return true;
        }

        // Already explored this index
        if (visited[start]) {
            return false;
        }

        // Mark this index as visited
        visited[start] = true;

        int n = arr.length;

        // Try jumping right
        int right = start + arr[start];

        if (right < n && solve(arr, right, visited)) {
            return true;
        }

        // Try jumping left
        int left = start - arr[start];

        if (left >= 0 && solve(arr, left, visited)) {
            return true;
        }

        // Neither direction reaches zero
        return false;
    }
}
