public class ReverseWordsString{
    public static String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();
        
        // Split the string by spaces
        String[] words = s.split("\\s+");
        
        // Use StringBuilder to construct the reversed string
        StringBuilder reversed = new StringBuilder();
        
        // Iterate through the words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" "); // Add space between words
            }
        }
        
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "  Hello   World  ";
        String output = reverseWords(input);
        System.out.println(output); // Output: "World Hello"
    }
}