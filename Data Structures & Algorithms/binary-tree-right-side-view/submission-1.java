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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        if(root == null)return ans;
        
        q.offerLast(root);
        while (!q.isEmpty()) {
            int n = q.size();
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.removeFirst();
                temp[i] = curr.val;

                if (curr.left != null)
                    q.offerLast(curr.left);
                if (curr.right != null)
                    q.offerLast(curr.right);
            }
            ans.add(temp[n - 1]);
        }
        return ans;
    }
}
