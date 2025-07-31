class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] find = new boolean[256];
        for(char ch : jewels.toCharArray()) find[ch] = true;

        int count = 0;
        for(char ch : stones.toCharArray()) if(find[ch]) count++;
        return count;
    }
}