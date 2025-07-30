class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i <= word.length(); i++) {
            char ch = i < word.length() ? word.charAt(i) : 'X';
            if(ch >= '0' && ch <= '9') {
                curr.append(ch);
            } else if(curr.length() > 0) {
                while(curr.length() > 1 && curr.charAt(0) == '0') curr.deleteCharAt(0);
                set.add(curr.toString());
                curr.setLength(0);
            }
        }
        return set.size();
    }
}