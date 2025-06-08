class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int n= arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(arr,0,dp);
    }

    private int solve(char[] arr, int idx,int[] dp){
        int n = arr.length;
        if(idx == n) return 1;
        if(dp[idx] != -1) return dp[idx];
        if(arr[idx] == '0') return dp[idx] = 0;
        int oneChar = 0,twoChar=0;
        oneChar = solve(arr,idx+1,dp);
        if(idx+1<n){
            if(arr[idx]=='1'||arr[idx]=='2' && arr[idx+1]<='6'){
                twoChar = solve(arr,idx+2,dp);
            }
        }
        return dp[idx]=oneChar + twoChar;
    }
}