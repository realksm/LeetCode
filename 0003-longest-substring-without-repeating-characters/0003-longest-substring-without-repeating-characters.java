class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int count = 0;
        Set<Character> set = new HashSet<>();

        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                count = Math.max(count,set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return count;
    }
}