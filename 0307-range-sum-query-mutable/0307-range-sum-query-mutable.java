class NumArray {
    // Segement Tree
    private int[] tree;
    private int n;

    public NumArray(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }
    
    private void build(int[] arr, int index, int start, int end) {
        if (start == end) {
            tree[index] = arr[start];
        } else {
            int mid = (start + end) / 2;

            build(arr, 2 * index + 1, start, mid);
            build(arr, 2 * index + 2, mid + 1, end);

            tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
        }
    }

    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }
    
    private void update(int index, int start, int end, int i, int val) {
        if (start == end) {
            tree[index] = val;
        } else {
            int mid = (start + end) / 2;

            if (i <= mid) {
                update(2 * index + 1, start, mid, i, val);
            } 
            else {
                update(2 * index + 2, mid + 1, end, i, val);
            }
            tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
        }
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int index, int start, int end, int l, int r) {
        if (r < start || end < l) { // NO overlap
            return 0;
        }
        if (l <= start && end <= r) { // Total overlap
            return tree[index];
        }
        // Partial overlap
        int mid = (start + end) / 2;

        int leftSum = query(2 * index + 1, start, mid, l, r);
        int rightSum = query(2 * index + 2, mid + 1, end, l, r);

        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */