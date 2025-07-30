class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i <= word.length(); i++) {
            char ch = i < word.length() ? word.charAt(i) : 'X';
            if(ch >= '0' && ch <= '9') {
                curr.append(ch);
            } else if(curr.length() > 0) {
                int j = 0;
                while(j < curr.length() && curr.charAt(j) == '0') j++;
                set.add(curr.toString().substring(j));
                curr.setLength(0);
            }
        }
        return set.size();
    }
}