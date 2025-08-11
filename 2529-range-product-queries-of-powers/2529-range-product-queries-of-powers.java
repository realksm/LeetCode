class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = (int) 1e9 + 7;
        int[] ans = new int[queries.length];

        List<Long> powers = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            if((n >> i & 1) == 1) powers.add(1L << i);
        }

        int m = powers.size();
        long[][] rangeProd = new long[m][m];

        for(int i = 0; i < m; i++) {
            long prod = 1;
            for(int j = i; j < m; j++) {
                prod *= powers.get(j);
                prod %= MOD;
                rangeProd[i][j] = prod;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            ans[i] = (int) rangeProd[queries[i][0]][queries[i][1]];
        }

        // for(int i = 0; i < queries.length; i++) {
        //     int left = queries[i][0];
        //     int right = queries[i][1];
            
        //     long prod = 1;
        //     for(int j = left; j <= right; j++) {
        //         prod *= powers.get(j);
        //         prod %= MOD;
        //     }
        //     ans[i] = (int) prod;
        // }
        return ans;
    }
}