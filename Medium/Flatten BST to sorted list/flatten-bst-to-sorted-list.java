//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class GFG
{
    public static void printList(Node head) {
        while (head != null) {
            if (head.left != null)
                System.out.print("-1 ");
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String str = sc.nextLine();
            Node root = buildTree(str);
            Solution ob = new Solution();
            Node ans = ob.flattenBST(root);
            printList(ans);
        }
        sc.close();
    }

    private static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String[] ip = str.split("\\s+");
        int index = 0;

        Node root = new Node(Integer.parseInt(ip[index++]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && index < ip.length) {
            Node currNode = queue.poll();

            String currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            if (index >= ip.length)
                break;
            currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
        }

        return root;
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    List<Integer> values = new ArrayList<>();
    public Node flattenBST(Node root) {
        dfs(root);
        Node ans = new Node(0);
        Node res = ans;
        for(int i : values) {
            res.right = new Node(i);
            res = res.right;
        }
        return ans.right;
    }
    public void dfs(Node root) {
        if(root == null) return;
        dfs(root.left);
        values.add(root.data);
        dfs(root.right);
    }
}
