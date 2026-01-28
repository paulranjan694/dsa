class Solution {
    int[] memo;
    public int numSquares(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return solve(n);
    }

    private int solve(int n){
        if(n==0) return 0;
        if(memo[n] != -1) return memo[n];
        int limit = (int)Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=limit;i++){
            int t = 1+solve(n-i*i);
            min=Math.min(min,t);
        }
        return memo[n]=min;
    }
}