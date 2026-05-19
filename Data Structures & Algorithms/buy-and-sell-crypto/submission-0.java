class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int n = prices.length;
        int profit = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return profit < 0 ? 0 : profit;
    }
}
