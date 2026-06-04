class Solution {
    public int solve(TreeNode root, int maxVal) {
        if (root == null)
            return 0;
        maxVal = Math.max(maxVal, root.val);
        // System.out.println("Root: "+root.val+" maxVal: "+maxVal);
        int leftAns = solve(root.left, maxVal);
        int rightAns = solve(root.right, maxVal);

        if (root.val >= maxVal)
            return leftAns + rightAns + 1;

        return leftAns + rightAns;
    }
    public int goodNodes(TreeNode root) {
        return solve(root, root.val);
    }
}