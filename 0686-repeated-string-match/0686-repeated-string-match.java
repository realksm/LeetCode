class Solution {
    public int repeatedStringMatch(String a, String b) {
        int rep = (a.length() + b.length() - 1) / a.length();
        StringBuilder sb = new StringBuilder(a.repeat(rep));
        for(int i = 0; i < 2; i++) {
            if(sb.toString().contains(b)) {
                return rep;
            }
            rep++;
            sb.append(a);
        }
        return -1;
    }
}