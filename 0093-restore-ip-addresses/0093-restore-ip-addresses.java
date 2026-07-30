class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();

        backtrack(0, 0, s, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int index, int parts, String s, List<String> path, List<String> ans) {

        // Valid IP formed
        if (parts == 4 && index == s.length()) {
            ans.add(String.join(".", path));
            return;
        }

        // Invalid state
        if (parts == 4 || index == s.length()) {
            return;
        }

        // Try segment length = 1,2,3
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String segment = s.substring(index, index + len);

            // Leading zero
            if (segment.length() > 1 && segment.charAt(0) == '0') continue;

            int value = Integer.parseInt(segment);

            if (value > 255) continue;

            path.add(segment);

            backtrack(index + len, parts + 1, s, path, ans);

            path.remove(path.size() - 1);
        }
    }
}