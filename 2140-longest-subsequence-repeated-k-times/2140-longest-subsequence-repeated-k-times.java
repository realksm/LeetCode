class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] count = new int[26];
        for (final char c : s.toCharArray()) ++count[c - 'a'];
    
        Queue<String> q = new ArrayDeque<>(List.of(""));
        String ans = "";
        while (!q.isEmpty()) {
            final String currSubseq = q.poll();
            if (currSubseq.length() * k > s.length())
                return ans;
            for (char c = 'a'; c <= 'z'; c++) {
                if(count[c - 'a'] < k) continue;
                final String newSubseq = currSubseq + c;
                if (isSubsequence(newSubseq, s, k)) {
                    q.offer(newSubseq);
                    ans = newSubseq;
                }
            }
        }

        return ans;
    }

    private boolean isSubsequence(final String subseq, final String s, int k) {
        int i = 0;
        for (final char c : s.toCharArray())
            if (c == subseq.charAt(i))
                if (++i == subseq.length()) {
                    if (--k == 0)
                        return true;
                    i = 0;
                }
        return false;
    }
}