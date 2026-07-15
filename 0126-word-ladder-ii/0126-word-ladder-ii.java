class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return result;

        // Parent mapping
        Map<String, List<String>> parentMap = new HashMap<>();

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();
            Set<String> currentLevelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;
                        String newWord = new String(arr);

                        if (dict.contains(newWord)) {

                            if (!visited.contains(newWord)) {

                                if (!currentLevelVisited.contains(newWord)) {
                                    queue.offer(newWord);
                                    currentLevelVisited.add(newWord);
                                }

                                if (!parentMap.containsKey(newWord)) {
                                    parentMap.put(newWord, new ArrayList<>());
                                }
                                parentMap.get(newWord).add(word);

                                if (newWord.equals(endWord)) {
                                    found = true;
                                }
                            }
                        }
                    }

                    arr[j] = original;
                }
            }

            visited.addAll(currentLevelVisited);
        }

        if (!found)
            return result;

        // DFS to build paths
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, beginWord, parentMap, path, result);

        return result;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> parentMap, List<String> path,List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!parentMap.containsKey(word))
            return;

        for (String parent : parentMap.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parentMap, path, result);
            path.remove(path.size() - 1);
        }
    }
}
