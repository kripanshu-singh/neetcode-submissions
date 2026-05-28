class Solution {
    public int findPivot(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    public int binary(int start, int end, int[] nums, int target) {
        // System.out.println("Start: "+start+" End: "+end);
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        // System.out.println("Pivot: " + pivot);
        int ans = -1;
        if (target > nums[nums.length - 1]) {
            ans = binary(0, pivot - 1, nums, target);
        } else {
            ans = binary(pivot, nums.length - 1, nums, target);
        }

        return ans;
    }
}
