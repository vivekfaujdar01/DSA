class MyHashMap {
    int[] keys;
    int[] values;
    int size;

    public MyHashMap() {
        // Initialize arrays with a fixed capacity
        keys = new int[10000];
        values = new int[10000];
        size = 0;
    }

    public void put(int key, int value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public int get(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return values[i];
            }
        }
        return -1; // Return -1 if key is not found
    }

    public void remove(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                // Overwrite the removed element with the last element
                keys[i] = keys[size - 1];
                values[i] = values[size - 1];
                size--;
                return;
            }
        }
    }
}
