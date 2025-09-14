class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
    // 1. Exact words
    Set<String> exact = new HashSet<>(wordlist.length * 2);

    // 2. Case-insensitive map
    Map<String, String> caseInsensitive = new HashMap<>(wordlist.length * 2);

    // 3. Vowel-insensitive map
    Map<String, String> vowelInsensitive = new HashMap<>(wordlist.length * 2);

    for (String word : wordlist) {
      exact.add(word);

      String lower = word.toLowerCase();
      caseInsensitive.putIfAbsent(lower, word);

      String vowel = vowelKey(lower);
      vowelInsensitive.putIfAbsent(vowel, word);
    }

    String[] ans = new String[queries.length];
    for (int i = 0; i < queries.length; i++) {
      String q = queries[i];
      if (exact.contains(q)) {
        ans[i] = q;
        continue;
      }

      String lower = q.toLowerCase();
      if (caseInsensitive.containsKey(lower)) {
        ans[i] = caseInsensitive.get(lower);
        continue;
      }

      String vowel = vowelKey(lower);
      ans[i] = vowelInsensitive.getOrDefault(vowel, "");
    }

    return ans;
  }

  // Avoid StringBuilder, build directly in char[]
  private String vowelKey(String word) {
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (isVowel(chars[i])) chars[i] = '*';
    }
    return new String(chars);
  }

  private boolean isVowel(char c) {
    // only lowercase chars ever reach here
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}