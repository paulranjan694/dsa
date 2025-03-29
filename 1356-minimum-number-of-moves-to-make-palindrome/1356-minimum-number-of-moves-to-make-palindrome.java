class Solution {
    public int minMovesToMakePalindrome(String s) {
        int moves=0,n=s.length(),l=0,r=n-1;
        char[] arr = s.toCharArray();

        while(l<=r){
            
            int k = r;
            while(k>l){
                if(arr[k]==arr[l]){
                    break;
                }
                k--;
            }

            if(l==k){
                int mid = n/2;
                moves += mid-l;
            }else{
                while(k<r){
                    char c = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1]=c;
                    k++;
                    moves++;
                }
                r--;
            }
        
            l++;
            
        }
        return moves;

        
    }
}