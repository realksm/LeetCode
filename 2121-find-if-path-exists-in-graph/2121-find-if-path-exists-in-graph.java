class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }   

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        
        while(!q.isEmpty()) {
            int curr = q.remove();

            if(curr == destination) return true;

            for(int neighbour : graph.get(curr)) {
                if(!vis[neighbour]) {
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return false;
    }
}