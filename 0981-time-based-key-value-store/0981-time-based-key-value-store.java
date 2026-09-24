class TimeMap {

    private Map<String, List<Pair>> map; // key -> list of (timestamp, value)

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new ArrayList<>()); // If key doesn't exist, create a new list
        
        map.get(key).add(new Pair(timestamp, value)); // Timestamps are strictly increasing
    }

    public String get(String key, int timestamp) {

        // Key doesn't exist
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        String answer = "";

        // Find the largest timestamp <= given timestamp
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {

                answer = list.get(mid).value; // This timestamp is valid

                left = mid + 1; // Try to find a later valid timestamp

            } else {
                right = mid - 1; // timestamp at mid is too large
            }
        }

        return answer;
    }

    // Stores timestamp + value
    static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */