class Solution {
    public int countBinarySubstrings(String s) {
        int prev=0, curr=1, ans=0, n = s.length();
        char[] arr = s.toCharArray();
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]){
                curr++;
            }else{
                ans += Math.min(prev,curr);
                prev=curr;
                curr=1;
            }
        }
        return ans + Math.min(prev,curr);
    }
}