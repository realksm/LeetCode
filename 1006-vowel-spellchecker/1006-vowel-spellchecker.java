class Solution {
    private static final boolean[] IS_VOWEL = new boolean[256];
    
    static {
        IS_VOWEL['a'] = IS_VOWEL['e'] = IS_VOWEL['i'] = IS_VOWEL['o'] = IS_VOWEL['u'] = true;
        IS_VOWEL['A'] = IS_VOWEL['E'] = IS_VOWEL['I'] = IS_VOWEL['O'] = IS_VOWEL['U'] = true;
    }
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>(wordlist.length * 4 / 3);
        Map<String, String> capWords = new HashMap<>(wordlist.length * 4 / 3);
        Map<String, String> vowelWords = new HashMap<>(wordlist.length * 4 / 3);
        
        for (String word : wordlist) {
            exactWords.add(word);
            
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
            
            capWords.putIfAbsent(lowerWord, word);
            vowelWords.putIfAbsent(vowelPattern, word);
        }
        
        String[] result = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }
            
            char[] lowerChars = new char[query.length()];
            char[] vowelChars = new char[query.length()];
            
            for (int j = 0; j < query.length(); j++) {
                char c = query.charAt(j);
                char lower = (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;
                lowerChars[j] = lower;
                vowelChars[j] = IS_VOWEL[c] ? '*' : lower;
            }
            
            String lowerQuery = new String(lowerChars);
            
            String capMatch = capWords.get(lowerQuery);
            if (capMatch != null) {
                result[i] = capMatch;
                continue;
            }
            
            String vowelPattern = new String(vowelChars);
            String vowelMatch = vowelWords.get(vowelPattern);
            result[i] = (vowelMatch != null) ? vowelMatch : "";
        }
        
        return result;
    }
}