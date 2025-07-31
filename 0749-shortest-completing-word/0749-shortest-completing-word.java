class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] freq = new int[26];

        for(char ch : licensePlate.toCharArray()) {
            if(!Character.isDigit(ch) && ch != ' ') freq[ch - 'a']++;
        } 

        int min = 0;
        String res = words[0];
        for(String word : words) {
            int curr = compare(Arrays.copyOf(freq, freq.length), word);
            if(curr > min) {
                min = curr;
                res = word;
            } else if(curr == min && word.length() < res.length()) {
                min = curr;
                res = word;
            }
        }
        return res;
    }

    private int compare(int[] freq, String s) {
        int count = 0;
        for(char ch : s.toCharArray()) {
            if(freq[ch - 'a'] > 0) {
                freq[ch - 'a']--;
                count++;
            }
        }
        return count;
    }
}