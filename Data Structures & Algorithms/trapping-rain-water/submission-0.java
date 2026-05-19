class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] bigLeft = new int[n];
        int[] bigRight = new int[n];
        bigLeft[0] = height[0];
        bigRight[n-1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            bigLeft[i] = Math.max(bigLeft[i-1], height[i]);
            bigRight[n-i-1] = Math.max(bigRight[n-i], height[n-i-1]);
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            // System.out.println("Height: "+height[i]+" left: "+bigLeft[i]+ " Right: "+bigRight[i]);
            ans = ans + (Math.min(bigLeft[i], bigRight[i]) - height[i]);
        }
        return ans;
    }
}
