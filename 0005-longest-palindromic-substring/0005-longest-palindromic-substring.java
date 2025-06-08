class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start=0,end=0,n=arr.length;
        if(n==1) return s;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(arr,i,j)){
                    if(end-start < j-i){
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }

    private boolean isPalindrome(char[] arr, int s, int e){
        if(s>=e) return true;
        if(arr[s]==arr[e]){
            return isPalindrome(arr, s+1, e-1);
        }
        else return false;
    }
}