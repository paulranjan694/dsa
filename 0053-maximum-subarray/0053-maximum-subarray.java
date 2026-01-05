class Solution {
    public int maxSubArray(int[] arr) {
        int max=-100000, idx=0, n = arr.length,sum=0;
        while(idx < n){
            sum += arr[idx];
            max = Math.max(sum,max);
            sum = Math.max(sum,0);
            idx++;
        }
        
        return max;
    }
}