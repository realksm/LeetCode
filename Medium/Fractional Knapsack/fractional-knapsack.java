//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
         Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2)
            {
                return o2.value * o1.weight - o1.value * o2.weight;
            }
        });
        
        double ans = 0d;
        
        for(Item i : arr) {
            int wgt = i.weight;
            int val = i.value;
            
            if(W - wgt >= 0) {
                W -= wgt;
                ans += val;
            } else {
                double frac = ((double)W / (double)wgt);
                ans += (frac * val);
                W = (int)(W - (val * frac));
                break;
            }
        }
        
        return ans;
    }
}