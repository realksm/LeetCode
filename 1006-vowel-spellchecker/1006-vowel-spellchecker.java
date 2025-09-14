class Solution {
    private static final long VOWEL_MASK = 0x104111L;
    
    private static boolean isVowel(char c) {
        int pos = (c | 32) - 'a';
        return pos >= 0 && pos < 26 && ((VOWEL_MASK >> pos) & 1) == 1;
    }
    
    // For cases where many repeated patterns exist
    private String internedLower(String s) {
        // Custom interning for lowercase versions
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = (char)(s.charAt(i) | 32);
        }
        return new String(chars).intern();
    }
    
    private String internedVowel(String s) {
        // Custom interning for vowel patterns
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[i] = isVowel(c) ? '*' : (char)(c | 32);
        }
        return new String(chars).intern();
    }
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caps = new HashMap<>();
        Map<String, String> vowels = new HashMap<>();
        
        // Use interning for repeated patterns
        for (String word : wordlist) {
            exact.add(word);
            caps.putIfAbsent(internedLower(word), word);
            vowels.putIfAbsent(internedVowel(word), word);
        }
        
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            if (exact.contains(query)) {
                result[i] = query;
            } else {
                String capMatch = caps.get(internedLower(query));
                if (capMatch != null) {
                    result[i] = capMatch;
                } else {
                    String vowelMatch = vowels.get(internedVowel(query));
                    result[i] = vowelMatch != null ? vowelMatch : "";
                }
            }
        }
        
        return result;
    }
}