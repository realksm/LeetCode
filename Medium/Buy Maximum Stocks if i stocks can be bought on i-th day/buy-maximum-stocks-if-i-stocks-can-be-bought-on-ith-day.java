//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

    class Order {
        int index;
        int price;
        public Order(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }
class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        Order[] order = new Order[n];

        for (int i = 0; i < n; i++) {
            order[i] = new Order(price[i], i + 1);
        }

        Arrays.sort(order, (a, b) -> Integer.compare(a.price, b.price));

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if(k < order[i].price) break;
            Order currentOrder = order[i];
            int stocksToBuy = Math.min(currentOrder.index, k / currentOrder.price);
            ans += stocksToBuy;
            k -= stocksToBuy * currentOrder.price;
        }

        return ans;
    }
}
        
