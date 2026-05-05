class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
              
        reverse(arr, 0, arr.length - 1); // reverse full string
        
        // reverse each word
        int start = 0;
        for (int end = 0; end <= arr.length; end++) {
            if (end == arr.length || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }
        
        return cleanSpaces(arr);
    }
    
    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
    
    public String cleanSpaces(char[] arr) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = arr.length;
        
        while (i < n) {
            while (i < n && arr[i] == ' ') i++; // skip spaces
            while (i < n && arr[i] != ' ') sb.append(arr[i++]);
            while (i < n && arr[i] == ' ') i++;
            if (i < n) sb.append(' ');
        }
        
        return sb.toString();
    }
}