class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = (long)n;
        long streak=0;
        for(int i=1;i<n;i++){
            if(prices[i]-prices[i-1] == -1){
                streak += 1;
            }else{
                streak=0;
            }
            ans+=streak;
        }
        
        return ans;
    }
}