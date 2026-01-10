class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(),m=s2.length();
        int[][] dp = new int[n][m];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        return utils(s1,s2,n,m,0,0,dp);
    }

    private int utils(String s1, String s2, int n, int m, int i, int j, int[][] dp){
        if(i==n){
            int sum=0;
            while(j<m){
                sum += s2.charAt(j);
                j++;
            }
            return sum;
        }

        if(j == m){
            int sum=0;
            while(i<n){
                sum += s1.charAt(i);
                i++;
            }
            return sum;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return utils(s1,s2,n,m,i+1,j+1,dp);
        }

        int sum1 = utils(s1, s2, n, m, i+1, j,dp) + s1.charAt(i);
        int sum2 = utils(s1, s2, n, m, i, j+1,dp) + s2.charAt(j);
        return dp[i][j] = Math.min(sum1,sum2);


    }


}