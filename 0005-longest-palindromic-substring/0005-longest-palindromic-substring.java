class Solution {
    int len=0,start=0;
    Boolean[][] memo;
    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n+1][n+1];
        solve(s.toCharArray(), 0,n-1);
        return s.substring(start, start+len+1);
    }

    private boolean solve(char[] arr, int i, int j){
        //base case
        if(i>=j) return true;
        if(memo[i][j] != null) return memo[i][j];
        if(arr[i]==arr[j]){
            if(isPalindrome(arr,i,j)){
                if(len < j-i){
                    len=j-i;
                    start=i;
                }
                return memo[i][j]=true;
            }
        }

        boolean first = solve(arr,i,j-1);
        boolean second = solve(arr,i+1,j);

        return memo[i][j] = first || second;
        
    }

    private boolean isPalindrome(char[] arr, int i, int j){
        while(i<=j){
            if(arr[i]!=arr[j]){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}