class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        //base case
        
        int[] next=new int[2];

        for(int day = n-1;day>=0;day--){
            int[] curr = new int[2];
            for(int buy=0;buy<2;buy++){
                if(buy == 0){
                    curr[buy] =  Math.max(-prices[day]+next[1], next[0]);
                }else{
                    curr[buy] = Math.max(prices[day]+next[0], next[1]);
                }
            }
            next = curr;
        }
        return next[0];
    }

    private int solve(int[] prices, int idx,int buy){
        if(idx==prices.length) return 0;
        if(buy == 0){
            return Math.max(-prices[idx]+solve(prices, idx+1,1), solve(prices,idx+1,0));
        }else{
            return Math.max(prices[idx]+solve(prices, idx+1,0), solve(prices,idx+1,1));
        }
    }
}