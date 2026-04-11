class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s2freq = new int[26];
        int[] s1freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1freq[s1.charAt(i) - 'a']++;
            s2freq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1freq, s2freq)){
            return true;
        }

        int start = 0;
        int end = s1.length();

        while (end < s2.length()) {

            s2freq[s2.charAt(end) - 'a']++;
            s2freq[s2.charAt(start) - 'a']--;

            if (Arrays.equals(s1freq, s2freq)) {
                return true;
            }

            start++;
            end++;
        }

        return false;
    }
}