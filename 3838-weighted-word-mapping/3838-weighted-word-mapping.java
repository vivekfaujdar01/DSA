class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] map = new char[26];

        for (int i = 0; i < 26; i++) {
            map[i] = (char)('z' - i);
        }

        StringBuilder ans = new StringBuilder();

        for (String word : words) {

            int sum = 0;

            for (char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }

            ans.append(map[sum % 26]);
        }

        return ans.toString();
    }
}