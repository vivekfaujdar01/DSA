class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> charFrequency1 = new HashMap<>();
        Map<Character, Integer> charFrequency2 = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            charFrequency1.put(ch, charFrequency1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            charFrequency2.put(ch, charFrequency2.getOrDefault(ch, 0) + 1);
        }

        Set<Character> chars1 = charFrequency1.keySet();
        Set<Character> chars2 = charFrequency2.keySet();
        for (char ch : chars1) {
            if (!chars2.contains(ch)) {
                return false;
            }
        }

        List<Integer> freq1 = new ArrayList<>(charFrequency1.values());
        List<Integer> freq2 = new ArrayList<>(charFrequency2.values());

        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);
    }
}