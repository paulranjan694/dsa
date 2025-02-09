class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        boolean zeroexists = false;
        int zero = n;
        for(int i=0;i<n;i++){
        if(arr[i]==0){
            zeroexists=true;
            arr[i]=zero++;
        }
        }
        if(zeroexists==false) return 0;
        
        for(int i=0;i<n;i++){
            int idx = Math.abs(arr[i])-1;
            if(arr[idx] > 0 && idx>=0 && idx < n){
            arr[idx] = -1 * Math.abs(arr[idx]);
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>0){
            return i+1;
            }
        }
        return n;
    }
}