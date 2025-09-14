class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3)
            return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (!Character.isLetterOrDigit(c))
                return false;

            if (Character.isLetter(c)) {
                char lower = (char) (c | 32);
                if (isVowel(lower)) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }

    private boolean isVowel(char c) {
        return ((1065233 >> (c - 'a')) & 1) != 0;
    }
}