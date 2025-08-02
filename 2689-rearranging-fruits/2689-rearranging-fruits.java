class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i : basket1) count.put(i, count.getOrDefault(i, 0) + 1);
        for(int i : basket2) count.put(i, count.getOrDefault(i, 0) - 1);
        int min = Integer.MAX_VALUE;
        for(int i : count.keySet()) min = Math.min(i, min);

        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> e : count.entrySet()) {
            if(e.getValue() % 2 != 0) return -1;
            for(int i = 0; i < Math.abs(e.getValue())/2; i++) list.add(e.getKey()); 
        }
        
        Collections.sort(list);
        long cost = 0;
        for(int i = 0; i < list.size() / 2; i++) {
            System.out.println(list.get(i));
            cost += Math.min(list.get(i), min * 2);
        }
        return cost;
    }
}