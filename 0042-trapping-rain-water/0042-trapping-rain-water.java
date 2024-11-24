class Solution {
    //optimise - TC - O(n) SC - O(1)
    public int trap2(int[] height) {
        int n = height.length;
        int lmax=0,rmax=0, l=0,r=n-1, total = 0;
        while(l < r){
            if(height[l] <= height[r]){
                int curr = lmax - height[l];
                if(curr > 0) {
                    total += curr;
                }else{
                    lmax = height[l];
                }
                l++;
            }else{
                int curr = rmax - height[r];
                if(curr > 0) {
                    total += curr;
                }else{
                    rmax = height[r];
                }
                r--;
            }
        }
        return total;
    }

    //TC - O(n). SC - O(n) => prefix and suffix arrays take n space
    public int trap(int[] height) {
        int n = height.length, total = 0;
        int[] prefixmax = new int[n];
        int[] suffixmax = new int[n];
        prefixmax[0] = height[0];
        suffixmax[n-1] = height[n-1];

        for(int i = 1; i < n; i++){
            prefixmax[i] = Math.max(prefixmax[i-1],height[i]);
        }

        for(int i = n-2; i >= 0; i--){
            suffixmax[i] = Math.max(suffixmax[i+1],height[i]);
        }

        for(int i=0;i<n;i++){
            total += Math.min(prefixmax[i],suffixmax[i]) - height[i];
        }

        return total;
    }
}