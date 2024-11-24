class Solution {
    public int trap(int[] height) {
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
}