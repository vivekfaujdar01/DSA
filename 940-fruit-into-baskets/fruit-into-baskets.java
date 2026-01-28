class Solution {
    public int totalFruit(int[] fruits) {
        // Approach (sliding window + hashmap)
        // actually this question is finding the longest continous subarray with atmost 2 distinct elements
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2){
                map.put(fruits[left],map.get(fruits[left]) - 1);

                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}