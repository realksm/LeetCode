//{ Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int y = Integer.parseInt(inputLine[2]);
            int[] a = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int[] b = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(inputLine[i]);
            }

            long ans = new Solution().maxTip(a, b, n, x, y);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends




class Pair{
    int x, y;
    Pair(int a, int b){
        x = a; 
        y = b;
    }
}

class Solution {
    long maxTip(int[] a, int[] b, int n, int x, int y) {
        // code here
        ArrayList<Pair> tips = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            tips.add(new Pair(a[i], b[i]));
        }
        
        Collections.sort(tips, (a1, b1) -> {return Math.abs(b1.x - b1.y) - Math.abs(a1.x - a1.y);});
        
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            Pair p = tips.get(i);
            
            if(y == 0 || (p.x >= p.y && x > 0)) {
                ans += p.x;
                x--;
            } else if(y > 0) {
                ans += p.y;
                y--;
            }
        }
        return ans;
    }
}
