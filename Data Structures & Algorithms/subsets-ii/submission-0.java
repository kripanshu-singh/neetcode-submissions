class Solution {
    public void solve(int i, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if(i >= nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Include
        temp.add(nums[i]);
        solve(i+1, nums, temp, ans);
        temp.remove(temp.size()-1);

        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        solve(i+1, nums, temp, ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, nums, temp, ans);
        return ans;
    }
}
