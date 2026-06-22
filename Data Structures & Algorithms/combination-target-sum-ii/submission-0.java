class Solution {
    public void solve(int i, int[] nums, int target, List<Integer> temp, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i >= nums.length || target < 0)
            return;

        temp.add(nums[i]);
        solve(i + 1, nums, target - nums[i], temp, ans);
        temp.remove(temp.size() - 1);
        int curr = nums[i];
        while (i < nums.length && nums[i] == curr) i++;
        solve(i, nums, target, temp, ans);
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, nums, target, temp, ans);
        return ans;
    }
}