class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length, low=0,high=n-1;
        char ans=letters[0];
        while(low<=high){
            int mid = (low+high)/2;
            if(target<letters[mid]){
                ans = letters[mid];
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}