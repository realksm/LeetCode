class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowel = 0, maxConsonant = 0;
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
            switch(c) {
                case 'a', 'e', 'i', 'o', 'u' -> maxVowel = Math.max(maxVowel, freq[c - 'a']);
                default -> maxConsonant = Math.max(maxConsonant, freq[c - 'a']);
            }
        }
        return maxVowel + maxConsonant;
    }
}