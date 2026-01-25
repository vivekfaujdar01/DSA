class Solution {
    public String removeDuplicates(String s) {
        // Approach (Using Stack)
        // if stack is not empty and top element of stack == current character then pop out the top of stack
        // else push element in stack 
        // build string from stack and return it as result

        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == s.charAt(i)){
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for(Character i : st){
            res.append(i);
        }
        return res.toString();
    }
}