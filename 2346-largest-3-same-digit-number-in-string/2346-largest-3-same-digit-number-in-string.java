class Solution {
    public String largestGoodInteger(String num) {
        char[] ch = num.toCharArray();
        int max = 0;
        boolean found = false;

        for(int i = 0; i < ch.length - 2; i++) {
            int j = i + 1;
            if((ch[i] == ch[j]) && (ch[j] == ch[j + 1])) {
                max = Math.max(max, ch[i] - '0');
                i = j + 1;
                found = true;
            }
        }

        return !found ? "" : String.valueOf(max).repeat(3);
    }
}