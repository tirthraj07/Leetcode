class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        for(; start < prices.length - 1; start++){
            if(prices[start + 1] > prices[start]){
                break;
            }
        }

        if(start == prices.length - 1){
            return 0;
        }

        int end = start + 1;
        int max_profit = prices[end] - prices[start];

        while(end < prices.length){
            int curr_profit = prices[end] - prices[start];
            max_profit = Math.max(max_profit, curr_profit);

            if(curr_profit < 0){
                start = end;
            }
            end += 1;
        }

        return max_profit;

    }
}