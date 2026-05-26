class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(0, digits, map, "", ans);

        return ans;
    }

    public void solve(int index, String digits, HashMap<Character, String> map, String current, List<String> ans) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        char digit = digits.charAt(index);

        String letters = map.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            
            // current.append(ch); we can use StringBuilder and apeend ch

            solve(index + 1, digits, map, current + ch, ans);

            // current.deleteCharAt(current.length() - 1); removing last ch
        }
    }
}