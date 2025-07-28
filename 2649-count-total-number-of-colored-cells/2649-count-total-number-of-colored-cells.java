class Solution {
    public long coloredCells(int n) {
        // 1 , 5, 13, 25, 41
        // 1 + 2^2 - 0^2
        // 5 + 3^2  - 1^1
        // 13 + 4^2 - 2^2
        // 25 + 5^2 - 3^2
        long res = 1;
        for(int i = 2; i <= n; i++) {
            res += (i * i) - ((i - 2) * (i - 2));
        }
        return res;
    }
}