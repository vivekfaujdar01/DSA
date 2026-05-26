class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = m - 1;

            int firstIndex = m;

            while (low <= high) {

                int mid = low + (high - low) / 2;
                long product = (long) spells[i] * potions[mid];

                if (product >= success) {
                    firstIndex = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            res[i] = m - firstIndex;
        }

        return res;
    }
}