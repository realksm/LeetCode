class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int count = 0;
        for (char c : chars)
            if (isVowel(c))
                count++;

        char[] vowels = new char[count];
        int idx = 0;
        for (char c : chars)
            if (isVowel(c))
                vowels[idx++] = c;
        
        Arrays.sort(vowels);

        idx = 0;
        for (int i = 0; i < n; i++)
            if (isVowel(chars[i]))
                chars[i] = vowels[idx++];

        return new String(chars);
    }

    private static final boolean[] VOWEL = new boolean[128];
    static {
        for (char c : "aeiouAEIOU".toCharArray())
            VOWEL[c] = true;
    }

    private boolean isVowel(char c) {
        return c < 128 && VOWEL[c];
    }
}