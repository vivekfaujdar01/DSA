class Solution {

    public int numTilePossibilities(String tiles) {

        char[] arr = tiles.toCharArray();

        Arrays.sort(arr); // Sort characters

        boolean[] used = new boolean[arr.length];

        return backtrack(arr, used);
    }

    private int backtrack(char[] arr, boolean[] used) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            // Skip already selected characters
            if (used[i]) {
                continue;
            }

            // Skip duplicate choices at the same level
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true; // Choose

            count++; // Current non-empty sequence

            count += backtrack(arr, used); // Explore

            used[i] = false; // Backtrack
        }

        return count;
    }
}
