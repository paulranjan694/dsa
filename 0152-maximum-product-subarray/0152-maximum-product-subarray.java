class Solution {
    public int maxProduct(int[] arr) {
        int prefix=1,suffix=1, max=Integer.MIN_VALUE, n = arr.length;
        
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            
            prefix = prefix * arr[i];
            suffix = suffix * arr[n-i-1];
            max = Math.max(max, Math.max(prefix,suffix));
        }
        return max;
    }
}