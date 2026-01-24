class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        return utils(s,p,n-1,m-1, dp);
    }

    private boolean utils(String s, String p, int i, int j, Boolean[][] dp){
        if(i<0 && j<0) {
            dp[i+1][j+1] = true;
            return true;
        }
        if(j<0 && i >= 0) {
            dp[i+1][j+1] = false;
            return false; 
        }

        if(i<0 && j>=0){
            while(j>=0){
                if(p.charAt(j) != '*'){
                    return dp[i+1][j+1]=false;
                }
                j--;
            }
            return dp[i+1][j+1]=true;
        }

        if(dp[i+1][j+1] != null) return dp[i+1][j+1];

        if(s.charAt(i) == p.charAt(j)){
            return dp[i+1][j+1] = utils(s,p,i-1,j-1, dp);
        }else{
            if(p.charAt(j)=='?'){
                return dp[i+1][j+1] = utils(s,p,i-1,j-1, dp);
            }else if(p.charAt(j) == '*'){
                boolean res = false;
                for(int k=i;k>=0;k--){
                    res |= utils(s,p,k-1, j-1, dp) | utils(s,p,k, j-1, dp);
                    if(res == true) return dp[i+1][j+1] = res;
                }
                return dp[i+1][j+1] = res;
            }else{
                return dp[i+1][j+1]=false;
            }
        }
    }
}