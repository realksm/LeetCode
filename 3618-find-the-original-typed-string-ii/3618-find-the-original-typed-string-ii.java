class Solution {
    public int possibleStringCount(String word, int k) {
        List<Integer> groups = getConsecutiveLetters(word);
        final int totalCombinations = (int) groups.stream().mapToLong(Integer::longValue).reduce(1L,
                (a, b) -> a * b % MOD);
        if (k <= groups.size())
            return totalCombinations;

        int[] dp = new int[k];
        dp[0] = 1; 

        for (int i = 0; i < groups.size(); ++i) {
            int[] newDp = new int[k];
            int windowSum = 0;
            int group = groups.get(i);
            for (int j = i; j < k; ++j) {
                newDp[j] = (newDp[j] + windowSum) % MOD;
                windowSum = (windowSum + dp[j]) % MOD;
                if (j >= group)
                    windowSum = (windowSum - dp[j - group] + MOD) % MOD;
            }
            dp = newDp;
        }

        final int invalidCombinations = Arrays.stream(dp).reduce(0, (a, b) -> (a + b) % MOD);
        return (totalCombinations - invalidCombinations + MOD) % MOD;
    }

    private static final int MOD = 1_000_000_007;
    
    private List<Integer> getConsecutiveLetters(final String word) {
        List<Integer> groups = new ArrayList<>();
        int group = 1;
        for (int i = 1; i < word.length(); ++i)
            if (word.charAt(i) == word.charAt(i - 1)) {
                ++group;
            } else {
                groups.add(group);
                group = 1;
            }
        groups.add(group);
        return groups;
    }
}