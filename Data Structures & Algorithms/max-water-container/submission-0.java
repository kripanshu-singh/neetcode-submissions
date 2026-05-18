class Solution {
    public int maxArea(int[] heights) {
        int ans = Integer.MIN_VALUE;
        int start = 0;
        int end = heights.length-1;
        while(start < end){
            int area = Math.min(heights[start], heights[end])*(end-start);
            ans = Math.max(ans, area);

            if(heights[start]<=heights[end]){
                start++;
            }
            else end--;
        }
        return ans;
    }
}
