class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[n+1][n+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return solve(arr,0,n-1,dp);
    }

    private int solve(char[] arr, int i, int j, int[][] dp){
        if(i>j || isPalindrom(arr,i,j)) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            if(isPalindrom(arr, i, k)){
                min = Math.min(min,1+solve(arr,k+1,j,dp));
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

    private boolean isPalindrom(char[] arr, int i,int j){
        while(i<=j && arr[i]==arr[j]){
            i++;
            j--;
        }
        return i>=j;
    }
}