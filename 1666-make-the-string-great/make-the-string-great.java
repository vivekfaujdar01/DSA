class Solution {
    public String makeGood(String s) {
        // Approach (using stack)
        // just check stack top - c == 32 this condition checks if both are opposite case and same letter
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!st.empty() && Math.abs(st.peek() - c) == 32){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for(char c : st){
            res.append(c);
        }
        return res.toString();
    }
}