class Solution {
    public int scoreOfParentheses(String s) {
        // Approach (Stack) 
        // Rules recap:
            // "()" → 1
            // "AB" → A + B
            // "(A)" → 2 × A
        // First pop() → get the inner group score
        // inner == 0  means we saw "()"
        // inner > 0  means we saw "(A)"
        // Second pop() → get the outer context score
        // This handles the rule:
            // AB → A + B
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(0);
            }
            else{ // c == ')'
                int inner = st.pop();
                int score = (inner == 0) ? 1 : 2 * inner;
                st.push(st.pop() + score);
            }
        }
        return st.pop();

        
    }
}