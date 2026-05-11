class Solution {
    public String removeStars(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!dq.isEmpty() && c == '*'){
                dq.pollLast();
            }
            else{
                dq.offerLast(c);
            }
        }

        StringBuilder res = new StringBuilder("");

        while(!dq.isEmpty()){
            res.append(dq.pollFirst());
        }

        return res.toString();
    }
}