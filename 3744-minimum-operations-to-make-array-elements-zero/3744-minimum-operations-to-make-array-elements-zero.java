class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for(int[] q : queries) {
            int l = q[0];
            int r = q[1];
            ans += (getOps(r) - getOps(l - 1) + 1) / 2;
        }
        return ans;
    }

    private long getOps(int n) {
        long res = 0;
        int ops = 0;
        for(int p4 = 1; p4 <= n; p4 *= 4) {
            int l = p4;
            int r = Math.min(n, p4 * 4 - 1);
            res += (long) (r - l + 1) * ++ops;
        }
        return res;
    }
}