class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0, d = 1; // d=1 means up-right, -1 means down-left

        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            r -= d; 
            c += d;

            if (r >= m) { r = m - 1; c += 2; d = -d; }
            if (c >= n) { c = n - 1; r += 2; d = -d; }
            if (r < 0)   { r = 0; d = -d; }
            if (c < 0)   { c = 0; d = -d; }
        }
        return res;
    }
}