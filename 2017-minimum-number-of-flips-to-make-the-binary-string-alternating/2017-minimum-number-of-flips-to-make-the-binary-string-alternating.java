class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int[][] count = new int[2][2];

        for (int i = 0; i < n; ++i)
            ++count[s.charAt(i) - '0'][i % 2];

        int ans = Math.min(count[1][0] + count[0][1], count[0][0] + count[1][1]);

        for (int i = 0; i < n; ++i) {
            --count[s.charAt(i) - '0'][i % 2];
            ++count[s.charAt(i) - '0'][(n + i) % 2];
            ans = Math.min(ans, Math.min(count[1][0] + count[0][1], count[0][0] + count[1][1]));
        }

        return ans;
    }
}