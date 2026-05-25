class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stk = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            int num = temperatures[i];
            while(!stk.isEmpty() && temperatures[stk.peek()]<num){
                int tempIndex = stk.pop();
                ans[tempIndex] = i - tempIndex;
            }
            stk.push(i);
        }
        return ans;
    }
}
