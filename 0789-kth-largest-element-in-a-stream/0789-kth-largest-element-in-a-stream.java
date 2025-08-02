class KthLargest {
    private final int k;
    private Queue<Integer> heap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) heapify(num);
    }
    
    public int add(int val) {
        heapify(val);
        return heap.peek();
    }

    private void heapify(int val) {
        heap.offer(val);
        if(heap.size() > k) heap.poll();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */