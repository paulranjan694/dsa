class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
                int profit=prices[i]-min;
                ans= Math.max(ans,profit);
            }
            min=Math.min(min,prices[i]);
        }
        return ans;
    }
}