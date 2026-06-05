class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stk = new ArrayDeque<>();

        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            k--;

            if (k == 0) {
                return root.val;
            }

            root = root.right;
        }
        return 0;
    }
}
