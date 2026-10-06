class Solution {
    public int minAddToMakeValid(String s) {
        // more clean code compare to previous one and i handle unnecessary conditions

        Stack<Character> st = new Stack<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else { // c == ')'
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    count++; // need one '('
                }
            }
        }

        // remaining '(' need ')'
        return count + st.size();
    }
}
