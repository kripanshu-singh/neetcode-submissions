class Solution {
    public void solve(
        int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] visited) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            solve(nums, temp, ans, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums, temp, ans, visited);
        return ans;
    }
}
