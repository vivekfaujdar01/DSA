/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // in this question we will store column as a key and row and node value as a pair value in hashmap 
    // we will sort the map values according to conditions
    // and we will maintain minCol and maxCol value so that we can traverse through the map and get our resulting values

    // Helper class to store row and value
    static class Pair {
        int row;
        int val;

        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    Map<Integer, List<Pair>> colMap = new HashMap<>();
    int minCol = 0, maxCol = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Step 1: DFS traversal with coordinates
        dfs(root, 0, 0);

        // Step 2: Prepare result
        List<List<Integer>> result = new ArrayList<>();

        // Step 3: Process columns from left to right
        for (int col = minCol; col <= maxCol; col++) {
            List<Pair> list = colMap.get(col);

            // Sort by row, then value
            Collections.sort(list, (a, b) -> {
                if (a.row != b.row) {
                    return a.row - b.row;
                }
                return a.val - b.val;
            });

            // Extract values
            List<Integer> colValues = new ArrayList<>();
            for (Pair p : list) {
                colValues.add(p.val);
            }

            result.add(colValues);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;

    // Check if the column already exists
    if (!colMap.containsKey(col)) {
        colMap.put(col, new ArrayList<>());
    }

    // Get the list for this column
    List<Pair> list = colMap.get(col);

    // Add (row, value) to the list
    list.add(new Pair(row, node.val));

    // Update column boundaries
    minCol = Math.min(minCol, col);
    maxCol = Math.max(maxCol, col);

    // Recurse
    dfs(node.left, row + 1, col - 1);
    dfs(node.right, row + 1, col + 1);
    }
}