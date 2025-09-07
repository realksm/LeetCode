class ProductOfNumbers {
    private int[] prefix;
    private int size;

    public ProductOfNumbers() {
        prefix = new int[100_001]; 
        prefix[0] = 1;
        size = 1;
    }

    public void add(int num) {
        if (num == 0) {
            prefix[0] = 1;
            size = 1;
        } else {
            prefix[size] = prefix[size - 1] * num;
            size++;
        }
    }

    public int getProduct(int k) {
        if (k >= size) {
            return 0;
        }
        return prefix[size - 1] / prefix[size - k - 1];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */