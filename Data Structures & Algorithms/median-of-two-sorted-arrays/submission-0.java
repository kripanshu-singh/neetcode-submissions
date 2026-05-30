class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length;
        int m = nums2.length;

        int total = n + m;
        int s1 = 0;
        int e1 = n;

        while (s1 <= e1) {
            int m1 = (s1 + e1) / 2;
            int m2 = ((total+1) / 2) - m1;

            int l1 = m1 == 0 ? Integer.MIN_VALUE : nums1[m1 - 1];
            int l2 = m2 == 0 ? Integer.MIN_VALUE : nums2[m2 - 1];

            int r1 = m1 == n ? Integer.MAX_VALUE : nums1[m1];
            int r2 = m2 == m ? Integer.MAX_VALUE : nums2[m2];

            if (l1 <= r2 && l2 <= r1) {
                double ans = 0;
                if (total % 2 == 0) {
                    ans = (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    ans = Math.max(l1, l2);
                }
                return ans;
            } else if (l1 > r2) {
                e1 = m1 - 1;
            } else if (l2 > r1) {
                s1 = m1 + 1;
            }
        }
        return 0.0;
    }
}
