class Solution {
    public void solve(int i, int[] nums, int target, List<Integer> temp, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i >= nums.length || target < 0) {
            return;
        }

        // Include
        temp.add(nums[i]);
        solve(i, nums, target-nums[i], temp, ans);
        temp.remove(temp.size() - 1);
        // Exclude
        solve(i + 1, nums, target, temp, ans);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, nums, target, temp, ans);
        return ans;
    }
}
