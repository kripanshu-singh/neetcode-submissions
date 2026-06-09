class Solution {
    public int ans = Integer.MIN_VALUE;
    public int solve(TreeNode root) {
        if (root == null)
            return 0;

        int leftAns = Math.max(0, solve(root.left));
        int rightAns = Math.max(0, solve(root.right));

        ans = Math.max(ans, leftAns + rightAns + root.val);
        return root.val + Math.max(leftAns, rightAns);
    }
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;

        solve(root);
        return ans;
    }
}