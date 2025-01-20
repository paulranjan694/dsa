class Solution {
    public int minMovesToMakePalindrome(String s) {
               int n = s.length();
       int i = 0,j=n-1;
       char[] arr = s.toCharArray();
       int move=0;
       while(i<=j){
     
         int k = j;
         //find arr[i] in backward direction of j
         while(i<k){
           if(arr[i]==arr[k]){
             while(k < j){
               char t = arr[k];
               arr[k] = arr[k+1];
               arr[k+1] = t;
               k++;
               move++;
             }
             j--;
             break;
           }
           k--;
         }
         
         //if no match found for arr[i], move arr[i] to mid of arr as it is not paired or exists single
         if(i==k){
           int mid = n/2;
           move += mid-i;
         }
         i++;
       }
       return move;
    }
}