//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj)
    {
        int[] tin = new int[v];
        int[] low = new int[v];
        int[] par = new int[v];
        Arrays.fill(tin, -1);
        Arrays.fill(low, -1);
        Arrays.fill(par, -1);
        
        for(int i = 0; i < v; i++) {
            if(tin[i] == -1) {
                dfs(i, tin, low, par, adj);
            }
        }
        
        for(int i = 0; i < ans.size(); i++) {
            Collections.sort(ans.get(i));
        }
        
        ans.sort((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return a.get(1) - b.get(1);
            }
            return a.get(0) - b.get(0);
        });
        return ans;
    }
    
    int time = 0;
    
    public void dfs(int node, int[] tin, int[] low, int[] par, ArrayList<ArrayList<Integer>> adj) {
        tin[node] = low[node] = time++;
        for(int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i);
            if(tin[v] == -1) {
                par[v] = node;
                dfs(v, tin, low, par, adj);
                
                if(low[v] > tin[node]) {
                    ArrayList<Integer> curr = new ArrayList<>();
                    curr.add(node);
                    curr.add(v);
                    ans.add(curr);
                } else {
                    low[node] = Math.min(low[node], low[v]);
                }
            } else if(tin[v] > -1 && v != par[node]) {
                low[node] = Math.min(low[node], low[v]);
            }
        }
    }
}