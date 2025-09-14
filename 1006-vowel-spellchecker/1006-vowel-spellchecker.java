class Solution {
    private static final boolean[] IS_VOWEL = new boolean[256];
    
    static {
        // Pre-compute vowel lookup for ASCII characters
        IS_VOWEL['a'] = IS_VOWEL['e'] = IS_VOWEL['i'] = IS_VOWEL['o'] = IS_VOWEL['u'] = true;
        IS_VOWEL['A'] = IS_VOWEL['E'] = IS_VOWEL['I'] = IS_VOWEL['O'] = IS_VOWEL['U'] = true;
    }
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // Use arrays for better performance
        Set<String> exactWords = new HashSet<>(wordlist.length * 4 / 3);
        Map<String, String> capWords = new HashMap<>(wordlist.length * 4 / 3);
        Map<String, String> vowelWords = new HashMap<>(wordlist.length * 4 / 3);
        
        // Process wordlist once with optimized operations
        for (String word : wordlist) {
            exactWords.add(word);
            
            // Inline toLowerCase and vowel pattern generation
            char[] lowerChars = new char[word.length()];
            char[] vowelChars = new char[word.length()];
            
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                char lower = (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;
                lowerChars[i] = lower;
                vowelChars[i] = IS_VOWEL[c] ? '*' : lower;
            }
            
            String lowerWord = new String(lowerChars);
            String vowelPattern = new String(vowelChars);
            
            // Use putIfAbsent for first occurrence
            capWords.putIfAbsent(lowerWord, word);
            vowelWords.putIfAbsent(vowelPattern, word);
        }
        
        // Process queries with pre-allocated result array
        String[] result = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            // 1. Exact match - fastest check
            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }
            
            // Generate lowercase and vowel pattern in one pass
            char[] lowerChars = new char[query.length()];
            char[] vowelChars = new char[query.length()];
            
            for (int j = 0; j < query.length(); j++) {
                char c = query.charAt(j);
                char lower = (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;
                lowerChars[j] = lower;
                vowelChars[j] = IS_VOWEL[c] ? '*' : lower;
            }
            
            String lowerQuery = new String(lowerChars);
            
            // 2. Capitalization match
            String capMatch = capWords.get(lowerQuery);
            if (capMatch != null) {
                result[i] = capMatch;
                continue;
            }
            
            // 3. Vowel error match
            String vowelPattern = new String(vowelChars);
            String vowelMatch = vowelWords.get(vowelPattern);
            result[i] = (vowelMatch != null) ? vowelMatch : "";
        }
        
        return result;
    }
}