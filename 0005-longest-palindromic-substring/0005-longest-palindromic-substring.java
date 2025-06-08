class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start=0,end=0,n=arr.length;
        if(n==1) return s;
        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(arr,i,j,dp) == 1){
                    if(end-start < j-i){
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start,end+1);
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