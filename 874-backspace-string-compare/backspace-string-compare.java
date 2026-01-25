class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Approach1 (Using Stack) but in this space complexity is O(n)
        // Approach2 (Using Two Pointer) 
        // we will point two pointers at the end of s and t string
        // For each string:
            // If current char is # → increase skip count
            // If skip count > 0 → skip the character
            // Else → this character is valid
        // Then:
            // Compare valid characters of both strings
            // If mismatch → false
            
        int i = s.length()-1;
        int j = t.length()-1;
        int skipSchar = 0, skipTchar = 0;
        while(i >= 0 || j >= 0){
            
            while(i >= 0){
                if(s.charAt(i) == '#'){
                    skipSchar++;
                    i--;
                }
                else if(skipSchar > 0){
                    skipSchar--;
                    i--;
                }
                else{
                    break;
                }
            }

            while(j >= 0){
                if(t.charAt(j) == '#'){
                    skipTchar++;
                    j--;
                }
                else if(skipTchar > 0){
                    skipTchar--;
                    j--;
                }
                else{
                    break;
                }
            }

            if(i>=0 && j>=0){
                if(s.charAt(i) != t.charAt(j) ){
                    return false;
                }
            }
            else{
                if(i>=0 || j>=0){
                    return false;
                }
            }

            i--;
            j--;
        }

        return true;
    }
}