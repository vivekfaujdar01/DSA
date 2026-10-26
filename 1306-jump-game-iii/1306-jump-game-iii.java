// Without tracking visited indices, recursion can repeat forever. We need a way to recognize that we've already explored an index.
// BFS Solution 
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        // Start BFS from the given index
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int index = queue.poll();

            // Target found
            if (arr[index] == 0) {
                return true;
            }

            // Jump right
            int right = index + arr[index];

            if (right < n && !visited[right]) {
                visited[right] = true;
                queue.offer(right);
            }

            // Jump left
            int left = index - arr[index];

            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                queue.offer(left);
            }
        }

        // No reachable index contains zero
        return false;
    }
}

