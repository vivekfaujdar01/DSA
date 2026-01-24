class Solution {
    public int calculate(String s) {
        // Approach(Using Stack)
        // in this we wil store prevOperator if we found * or / we will solve them on immediate basis like previous operator is * or / then resolve that one 
        char prevOp = '+';
        Stack<Integer> st = new Stack<>();
        int num = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+(c-'0');
            }

            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                if(prevOp == '+'){
                    st.push(num);
                }
                else if(prevOp == '-'){
                    st.push(-num);
                }
                else if(prevOp == '*'){
                    st.push(st.pop()*num);
                }
                else if(prevOp == '/'){
                    st.push(st.pop()/num);
                }

                prevOp = c;
                num = 0;
            }

        }
        int res = 0;
        for(int n : st){
            res += n;
        }
        return res;
    }
}