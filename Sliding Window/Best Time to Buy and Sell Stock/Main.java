public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

/*
 * 
 * Basically move low till you get a local minima before n-1 th day
 * Then move high till you find a point less than local minima before nth day
 * While moving high, compare update profit
 * 
 */

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int low = 0;
        int high = 0;

        while (low < prices.length - 1) {
            // finding local minima
            while (low < prices.length - 1 && prices[low] >= prices[low + 1]) {
                low++;
            }
            // minima not found
            if (low == prices.length)
                break;

            // minima found. Now compare profits till you reach point less than minima
            high = low + 1;
            while (high < prices.length && prices[high] >= prices[low]) {
                maxProfit = Math.max(maxProfit, prices[high] - prices[low]);
                high++;
            }
            // point less than minima not found.
            if (high == prices.length)
                break;
            // point less than minima found. Update low to new minima point
            low = high;
        }

        return maxProfit;
    }
}