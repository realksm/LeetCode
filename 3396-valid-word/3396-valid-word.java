class Solution {
    private static final int VOWEL_MASK = 1065233;

    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3)
            return false;

        int flags = 0;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!Character.isLetterOrDigit(c)) return false;

            int isLetter = Character.isLetter(c) ? 1 : 0;
            char lower = (char) (c | 32);
            int isVowel = isLetter & (((VOWEL_MASK >> (lower - 'a')) & 1));
            flags |= isVowel;
            flags |= (isLetter & (1 - isVowel)) << 1;
        }
        return flags == 3;
    }

    private boolean isVowel(char c) {
        return ((1065233 >> (c - 'a')) & 1) != 0;
    }
}