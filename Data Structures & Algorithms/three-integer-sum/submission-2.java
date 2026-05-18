class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int start = i + 1;
            int end = n - 1;
            int target = -nums[i];
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    ans.add(new ArrayList<>(temp));
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;

                } else if (nums[start] + nums[end] < target) {
                    start++;
                } else
                    end--;
            }
        }
        return ans;
    }
}
