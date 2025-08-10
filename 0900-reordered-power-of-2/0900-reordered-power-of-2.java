class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] cnt = digitCount(n);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(cnt, digitCount(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] digitCount(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        return count;
    }
}