class Solution {
    int[] memo = new int[59];
    
    public int integerBreak(int n) {
        Arrays.fill(memo,-1);
        return dfs(n);
    }

    private int dfs(int n){
        if(n==1) return 1;
        if(memo[n] != -1) return memo[n];
        int res = 0;
        for(int i=1;i<n;i++){
            int prod = i * Math.max(n-i,dfs(n-i));
            res = Math.max(res,prod);
        }
        return memo[n] = res;
    }
}