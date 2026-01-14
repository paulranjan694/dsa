class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        //int[][] dp = new int[n+1][m+1];

        // for(int i=0;i<=n;i++){
        //     dp[i][0]=1;
        // }

        int[] prev = new int[m+1];

        prev[0] = 1;

        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            curr[0] = 1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[m];
    }

    private int solve(String s, String t, int i, int j){
        //base case
        if(j<0) return 1;
        if(i<0) return 0;

        if(s.charAt(i) == t.charAt(j)){
            return solve(s, t, i-1, j-1) + solve(s, t, i-1, j);
        }
        return solve(s, t, i-1, j);
        
    }
}