class Solution {
    private static final int MOD = 1000000007;
     public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);
            return utils(0,s,n,dp);
    }

      private int utils(int idx, String s, int n, int[] dp){ 
            if(idx == n){
                  return 1;
            }
            if(dp[idx] != -1) return dp[idx];

            int one = 0, two = 0;
            if(s.charAt(idx) != '0')
                  one = utils(idx+1,s,n,dp);
            if(idx+1 < n && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx+1) <= '6')) )
                  two = utils(idx+2,s,n,dp);
            dp[idx] =one + two;
            return dp[idx];
      }
}