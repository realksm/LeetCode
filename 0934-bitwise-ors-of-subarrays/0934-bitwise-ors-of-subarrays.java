class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int left = 0;

        for (final int a : arr) {
            final int right = res.size();
            res.add(a);

            for (int i = left; i < right; ++i)
                if (res.get(res.size() - 1) != (res.get(i) | a))
                    res.add(res.get(i) | a);
            left = right;
        }

        return new HashSet<>(res).size();
    }
}