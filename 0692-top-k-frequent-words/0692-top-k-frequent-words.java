class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Approach(Using map + priorityQueue)
        // adding strings and their frequency in map 
        // then make min-heap priorityqueue  because we can poll out less frequency element direcly and it also follows conditions
        // if size of heap greater than k then poll out element and at the end add result into list and return result in reverse because we use min heap
        
        // Frequency Map
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Min-Heap with custom comparator
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (freqMap.get(a).equals(freqMap.get(b))) { 
                    return b.compareTo(a);  // reverse lexicographical order
                }
                return freqMap.get(a) - freqMap.get(b);     // increasing frequency
            }
        );

        // Maintain heap size = k
        for (String word : freqMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Extract result
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // reverse because min-heap
        Collections.reverse(result);
        return result;
    }
}