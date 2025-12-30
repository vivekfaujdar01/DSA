class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int n1 = st.pop();
                int n2 = st.pop();

                if (token.equals("+")) {
                    st.add(n2 + n1);
                } 
                else if (token.equals("-")) {
                    st.add(n2 - n1);
                } 
                else if (token.equals("*")) {
                    st.add(n2 * n1);
                } 
                else if (token.equals("/")) {
                    st.add(n2 / n1); 
                }

            } 
            else {
                st.add(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}
