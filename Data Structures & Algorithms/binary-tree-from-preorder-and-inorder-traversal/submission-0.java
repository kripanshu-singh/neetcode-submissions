class Solution {
    public TreeNode solve(
        int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie)
            return null;

        TreeNode root = new TreeNode(preorder[ps]);
        int rootInd = map.get(preorder[ps]);
        int numOfLeft = rootInd - is;

        root.left = solve(preorder, ps + 1, ps + numOfLeft, inorder, is, rootInd - 1, map);
        root.right = solve(preorder, ps + numOfLeft + 1, pe, inorder, rootInd + 1, ie, map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return solve(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }
}
