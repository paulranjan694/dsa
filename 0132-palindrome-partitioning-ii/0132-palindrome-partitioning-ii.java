class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[n+1][n+1];
        Boolean[][] palin = new Boolean[n+1][n+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return solve(arr,0,n-1,dp,palin);
    }

    private static int solve(char[] arr, int i, int j, int[][] dp,Boolean[][] palin){
        if(i>j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(isPalindrom(arr,i,j,palin)) return dp[i][j] = 0;

        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            if(isPalindrom(arr, i, k,palin)){
                int right = 0;
                if(dp[k+1][j] != -1){
                    right = dp[k+1][j];
                }else{
                    right = dp[k+1][j] = solve(arr,k+1,j,dp,palin);
                }
                min = Math.min(min,1+right);
            }
            // int left=0;
            // if(dp[i][k] != -1){
            //     left = dp[i][k];
            // }else{
            //     left = dp[i][k] = solve(arr,i,k,dp);
            // }

            // int right = 0;
            // if(dp[k+1][j] != -1){
            //     right = dp[k+1][j];
            // }else{
            //     right = dp[k+1][j] = solve(arr,k+1,j,dp);
            // }

            // int temp = left + right + 1;
            // min = Math.min(min,temp);
        }
        return dp[i][j] = min;
    }

    private static boolean isPalindrom(char[] arr, int i,int j, Boolean[][] palin){
        if(palin[i][j] != null) return palin[i][j];
        int a=i,b=j;
        while(i<=j && arr[i]==arr[j]){
            i++;
            j--;
        }
        return palin[a][b]=(i>=j);
    }
}