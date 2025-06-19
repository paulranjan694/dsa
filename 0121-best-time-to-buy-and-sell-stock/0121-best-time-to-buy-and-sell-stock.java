class Solution {
    public int maxProfit(int[] prices) {
        int maxiProfit = 0,left=0,right=1,n=prices.length;
        while(right < n){
            if(prices[right]-prices[left] < 0){
                left=right;
            }else{
                maxiProfit = Math.max(maxiProfit,prices[right]-prices[left]);
            }
            right++;
        }
        return maxiProfit;
    }
}