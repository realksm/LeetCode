class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        bt(ans, "", 0, 0, n);
        return ans;
    }
    public void bt(List<String> ans, String str, int open, int close, int max) {
        if(str.length() == 2*max) {
            ans.add(str);
            return;
        }

        if(open < max) {
            bt(ans, str + "(", open + 1, close, max);
        }
        if(close < open) {
            bt(ans, str + ")", open, close + 1, max);
        }
    }
}