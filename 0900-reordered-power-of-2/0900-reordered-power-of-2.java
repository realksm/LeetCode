class Solution {
    public boolean reorderedPowerOf2(int n) {
        int targetSignature = digitSignature(n);
        for (int i = 0; i < 30; i++) {
            if (digitSignature(1 << i) == targetSignature) {
                return true;
            }
        }
        return false;
    }

    private int digitSignature(int n) {
        int signature = 0;
        while (n > 0) {
            signature += 1 << (n % 10);
            n /= 10;
        }
        return signature;
    }
}