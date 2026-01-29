class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), count=0;
        char[] arr = s.toCharArray();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(arr,i,j)){
                    count++;
                }
            }
        }
        return count;
        
    }

    private boolean check(char[] arr, int i, int j){
        if(i>=j) return true;

        if(arr[i]==arr[j]){
            return check(arr,i+1,j-1);
        }
        return false;
    }
}