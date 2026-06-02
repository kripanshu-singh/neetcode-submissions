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
    class Pair{
        int height = 0;
        int diameter = 0;
    }
    public Pair solve(TreeNode root) {
        if(root == null)return new Pair();

        Pair leftPair = solve(root.left);
        Pair rightPair = solve(root.right);


        Pair ans = new Pair();
        ans.height = Math.max(leftPair.height, rightPair.height)+1;
        int diameterThroughRoot = leftPair.height + rightPair.height + 1;

        ans.diameter = Math.max(leftPair.diameter, Math.max(rightPair.diameter, diameterThroughRoot));
        return ans;

    }
    public int diameterOfBinaryTree(TreeNode root) {

        return solve(root).diameter - 1;
    }
}
