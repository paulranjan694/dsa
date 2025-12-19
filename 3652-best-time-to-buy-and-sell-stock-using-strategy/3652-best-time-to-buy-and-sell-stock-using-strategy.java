class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefixProfit = new long[n+1];
        long[] prefixPrice = new long[n+1];

        for(int i=0;i<n;i++){
            prefixProfit[i+1] = prefixProfit[i] + prices[i]*strategy[i];
            prefixPrice[i+1] = prefixPrice[i]+prices[i];
        }

        long max=prefixProfit[n];
        
        
        for(int i=k-1;i<n;i++){
            long leftProfit = prefixProfit[i-k+1];
            long rightProfit = prefixProfit[n]-prefixProfit[i+1];
            long changeProfit = prefixPrice[i+1] - prefixPrice[i-k/2+1];
            max = Math.max(max, leftProfit+rightProfit+changeProfit);
        }
        return max;
    }
}