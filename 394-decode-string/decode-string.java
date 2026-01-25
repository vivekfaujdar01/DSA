class Solution {
        // We’ll use two stacks
        // Traverse the string character by character
        // If digit → build number
        // If [ → push number & current string to stacks
        // If letter → append to current
        // If ] → pop stack, repeat string, merge
        // Return current
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> countString = new Stack<>();
        int num = 0;
        StringBuilder currString = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+(c-'0');
            }
            else if(c == '['){
                countStack.push(num);
                countString.push(currString);
                currString = new StringBuilder();
                num = 0;
            }
            else if(c == ']'){
                int count = countStack.pop();
                StringBuilder prevString = countString.pop();
                for(int j=0;j<count;j++){
                    prevString.append(currString);
                }
                currString = prevString;
            }
            else{
                currString.append(c);
            }
        }
        return currString.toString();
    }
}