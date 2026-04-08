class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
 
        HashMap<String, List<String>> map = new HashMap<>(); // Map: sorted string -> list of anagrams 
        for (String str : strs) {
 
            char[] arr = str.toCharArray(); // Convert string to char array and sort
            Arrays.sort(arr);
            
            String key = new String(arr);
 
            if (!map.containsKey(key)) { // If key not present, create new list
                map.put(key, new ArrayList<>());
            }
  
            map.get(key).add(str); // Add original string
        }

        List<List<String>> result = new ArrayList<>();
        
        for (List<String> group : map.values()) {
            result.add(group);
        }
        
        return result;
    }
}