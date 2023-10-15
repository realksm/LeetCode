/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(k == 0) res.add(target.val);
        else dfs(res, root, target.val, k, 0); 
        return res;
    }
    public int dfs(List<Integer> res, TreeNode root, int target, int k, int depth) {
        if(root == null) return 0;

        if(depth == k) {
            res.add(root.val);
            return 0;
        }

        int left, right;
        if(root.val == target || depth > 0) {
            left = dfs(res, root.left, target, k, depth + 1);
            right = dfs(res, root.right, target, k, depth + 1);
        } else {
            left = dfs(res, root.left, target, k, depth);
            right = dfs(res, root.right, target, k, depth);
        }

        if(root.val == target) return 1;

        if(left == k || right == k) {
            res.add(root.val);
            return 0;
        }

        if(left > 0) {
            dfs(res, root.right, target, k, left + 1);
            return left + 1;
        }

        if(right > 0) {
            dfs(res, root.left, target, k, right + 1);
            return right + 1;
        }
        return 0;
    }
}