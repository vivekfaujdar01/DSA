class Solution {
    // Check if we can place m balls with at least 'dist'
    public static boolean canPlace(int[] position, int m, int dist) {
        int count = 1; // first ball at position[0]
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= dist) {
                count++;
                last = position[i];
            }
            if (count >= m) return true;
        }

        return false;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length - 1] - position[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(position, m, mid)) {
                ans = mid;       // store answer
                low = mid + 1;   // try bigger distance
            } else {
                high = mid - 1;  // reduce distance
            }
        }

        return ans;
    }
}