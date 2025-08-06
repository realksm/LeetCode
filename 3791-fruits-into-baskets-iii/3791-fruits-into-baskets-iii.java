class Solution {
    private int n;
    private int[] tree;
    
    public void build(int[] arr) {
        this.n = arr.length;
        this.tree = new int[n * 4];
        build(arr, 0, 0, n - 1);
    }

    public void update(int i, int val) {
        update(0, 0, n - 1, i, val);
    }

    public int query(int target) {
        return query(0, 0, n - 1, target);
    }

    private void build(int[] arr, int treeIndex, int low, int high) {
        if(low == high) {
            tree[treeIndex] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        build(arr, 2 * treeIndex + 1, low, mid);
        build(arr, 2 * treeIndex + 2, mid + 1, high);
        tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    private void update(int treeIndex, int low, int high, int i, int val) {
        if(low == high) {
            tree[treeIndex] = val;
            return;
        }

        int mid = (low + high) / 2;
        if(i <= mid) 
            update(2 * treeIndex + 1, low, mid, i, val);
        else 
            update(2 * treeIndex + 2, mid + 1, high, i, val);

        tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    private int query(int treeIndex, int low, int high, int target) {
        if(tree[treeIndex] < target) return -1;

        if(low == high) {
            update(low, -1);
            return low;
        }

        int mid = (low + high) / 2;
        int left = tree[2 * treeIndex + 1];
        if(left >= target) {
            return query(2 * treeIndex + 1, low, mid, target);
        } else {
            return query(2 * treeIndex + 2, mid + 1, high, target);
        }
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        build(baskets);

        for(int f : fruits) {
            if(query(f) == -1) ans++;
        } 

        return ans;
    }
}