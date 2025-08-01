class Solution {
    public int maxRepeating(String sequence, String word) {
        int res = 1;
        while(sequence.contains(word.repeat(res))) res++;
        return res - 1;
    }
}