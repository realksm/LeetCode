class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int[] max = new int[2];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
            int idx = (((1 << (c - 'a')) & 0x104111) != 0) ? 1 : 0;
            max[idx] = Math.max(max[idx], freq[c - 'a']);
        }
        return max[0] + max[1];
    }
}