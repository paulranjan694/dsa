class Solution {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int count=0,n=arr.length;
        //if(n==1) return s;
        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(arr,i,j,dp) == 1){
                    count++;
                }
            }
        }

        return count;
    }

    private int isPalindrome(char[] arr, int s, int e, int[][] dp){
        if(s>=e) return 1;
        if(dp[s][e] != -1) return dp[s][e];
        if(arr[s]==arr[e]){
            return dp[s][e] = isPalindrome(arr, s+1, e-1,dp);
        }
        else return dp[s][e] = 0;
    }
}