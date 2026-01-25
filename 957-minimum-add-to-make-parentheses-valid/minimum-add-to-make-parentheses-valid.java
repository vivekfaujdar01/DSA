class Solution {
    private Stack<Character> st = new Stack<>();

    public boolean match(char c){
        if(c == ')' && st.peek() == '('){
            return true;
        }
        else if(st.peek() == '[' && c == ']'){
            return true;
        }
        else if(st.peek() == '{' && c== '}'){
            return true;
        }
        else{
            return false;
        }
    } 
    public int minAddToMakeValid(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ')' || c == ']' || c == '}'){
                if(st.isEmpty()){
                    count++;
                }
                else if(!st.isEmpty() && !match(c)){
                    count++;
                    st.pop();
                }
                else{
                    st.pop();
                }
            }
            else if(c == '(' || c =='[' || c == '{'){
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            count++;
            st.pop();
        }
        return count;
    }
}