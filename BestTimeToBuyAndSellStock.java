public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null || prices.length==0)
            return 0;

        int bot = prices[0];
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
        	if(prices[i]<bot)
        		bot = prices[i];
        	else if(prices[i]-bot>maxProfit)
        		maxProfit = prices[i]-bot;
        }

        return maxProfit;

    }
}