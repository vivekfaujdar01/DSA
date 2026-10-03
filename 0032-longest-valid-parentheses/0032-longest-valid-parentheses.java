class Solution {
    public int longestValidParentheses(String s) {
        // Approach(Using Stack)
        Stack<Integer> st = new Stack<>();
        st.push(-1); // we are pushing it for handling the first invalid bracket like ')()()'
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else { // c == ')'
                st.pop();
                if (st.isEmpty()) {
                    st.push(i); // we are pushing invalid bracket index by which we can track the valid parentheses that will ahead of it;
                } else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }
}

// TWO PASS COUNTER (Most Space-Optimized)
// class Solution {
//     public int longestValidParentheses(String s) {
//         int left = 0, right = 0, maxLen = 0;

//         // Left to Right
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') left++;
//             else right++;

//             if (left == right) {
//                 maxLen = Math.max(maxLen, 2 * right);
//             } else if (right > left) {
//                 left = right = 0;
//             }
//         }

//         // Right to Left
//         left = right = 0;
//         for (int i = s.length() - 1; i >= 0; i--) {
//             if (s.charAt(i) == '(') left++;
//             else right++;

//             if (left == right) {
//                 maxLen = Math.max(maxLen, 2 * left);
//             } else if (left > right) {
//                 left = right = 0;
//             }
//         }

//         return maxLen;
//     }
// }
