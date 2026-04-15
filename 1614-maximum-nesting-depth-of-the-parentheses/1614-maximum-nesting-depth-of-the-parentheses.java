class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
                maxDepth = Math.max(maxDepth, st.size());
            } else if (ch == ')') {
                st.pop();
            }
        }
        return maxDepth;
    }
}