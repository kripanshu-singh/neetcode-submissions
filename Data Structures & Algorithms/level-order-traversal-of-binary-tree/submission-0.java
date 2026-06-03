/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        q.addLast(root);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.pollFirst();
                if (curr.left != null) {
                    q.addLast(curr.left);
                }
                if (curr.right != null) {
                    q.addLast(curr.right);
                }
                temp.add(curr.val);
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
