class Solution {
    public void solve(int i, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if(i >= nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // PUT
        temp.add(nums[i]);
        solve(i+1, nums, temp, ans);
        temp.remove(temp.size()-1);
        solve(i+1, nums, temp, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, nums, temp, ans);
        return ans;
    }
}
