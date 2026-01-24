class Solution {
    public int calculate(String s) {
        // Approach (using stack to evaluate expression)
        // in this there is no operator other then + and - then there is no need for operator precedence
        // when we find '(' at that time we will store context of res and sign and sign is at the top
        // in this question we have to handle unary minus mainly
        // when we find ')' then we first evaluate res with sign ad then we evaluate stack store res by popping it out
        // at the end after loop we evaluate res because 1 number left at that time 
        Stack<Integer> st = new Stack<>();
        int num = 0, sign = 1, res = 0;
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if(ch == '+'){
                res += num * sign;
                num = 0;
                sign = 1;
            }
            else if(ch == '-'){
                res += num * sign;
                num = 0;
                sign = -1;
            }
            else if(ch == '('){
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            }
            else if(ch == ')'){
                res += num * sign;
                num = 0;
                int prevSign = st.pop();
                int prevRes = st.pop();
                res = prevRes +  prevSign * res; 
            }
        }
        // number that left in the end
        res += num * sign;
        return res;
    }
}