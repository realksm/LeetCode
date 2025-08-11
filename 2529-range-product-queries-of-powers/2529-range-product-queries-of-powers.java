class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = (int) 1e9 + 7;
        int[] ans = new int[queries.length];

        List<Long> powers = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            if((n >> i & 1) == 1) powers.add(1L << i);
        }

        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            long prod = 1;
            for(int j = left; j <= right; j++) {
                prod *= powers.get(j);
                prod %= MOD;
            }
            ans[i] = (int) prod;
        }

        // 1 2 4 8
        // 1 2 8 64
        // 2  4  64
        return ans;
    }
}