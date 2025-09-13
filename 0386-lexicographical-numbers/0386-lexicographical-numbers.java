class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        int curr = 1;

        for (int i = 0; i < n; i++) {
            ans.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr == n) {
                    curr /= 10;
                }
                curr++;
            }
        }
        return ans;
    }
}