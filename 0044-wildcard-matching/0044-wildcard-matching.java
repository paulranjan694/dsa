class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];

        dp[0][0] = true;

        for(int i=1;i<=n;i++){
            dp[i][0] = false;
        }

        for(int j=1;j<=m;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = true && dp[0][j-1];
            }else{
                dp[0][j] = false;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(p.charAt(j-1)=='?'){
                        dp[i][j] = dp[i-1][j-1];
                    }else if(p.charAt(j-1) == '*'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }else{
                        dp[i][j]=false;
                    }
                }
            }
        }

        return dp[n][m];
    }

    public boolean isMatch2(String s, String p) {
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
                return dp[i+1][j+1] = utils(s,p,i-1, j, dp) | utils(s,p,i, j-1, dp);
            }else{
                return dp[i+1][j+1]=false;
            }
        }
    }
}