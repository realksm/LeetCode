class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> last = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rains.length; i++){
            int lake = rains[i];
            if (lake != 0){
                if (last.containsKey(lake)){
                    boolean found = false;
                    Iterator<Integer> it = q.iterator();
                    while (it.hasNext()){
                        int j = it.next();
                        if (j > last.get(lake)){
                            res.set(j, lake);
                            it.remove();
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        return new int[0];
                }
                res.add(-1);
                last.put(lake, i);
            } else {
                res.add(1);
                q.add(i);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}