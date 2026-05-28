class Solution {
    // using trie
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        for (String product : products) {
            insert(product);
        }

        return search(searchWord);
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];

            if (node.suggestions.size() < 3) {
                node.suggestions.add(word);
            }
        }
    }

    private List<List<String>> search(String searchWord) {

        List<List<String>> ans = new ArrayList<>();

        TrieNode node = root;

        for (char ch : searchWord.toCharArray()) {

            int idx = ch - 'a';

            if (node != null) {
                node = node.children[idx];
            }

            if (node == null) {
                ans.add(new ArrayList<>());
            } else {
                ans.add(node.suggestions);
            }
        }

        return ans;
    }
}