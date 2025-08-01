class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0) return 0;

        for(int i = 1; i <= num; i++) {
            int rem = num - k * i;
            if(rem >= 0 && (rem % 10 == 0)) return i;
        }

        return -1;
    }
}