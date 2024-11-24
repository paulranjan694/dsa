class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lmax=0,rmax=0, l=0,r=n-1, total = 0;
        while(l < r){
            int curr = 0 ;
            if(lmax <= rmax)
                curr = lmax - height[l];
            else
                curr = rmax - height[r];

            if(curr > 0){
                total += curr;
            }

            lmax = Math.max(lmax,height[l]);
            rmax = Math.max(rmax,height[r]);
            if(lmax > rmax){
                r--;
            }else{
                l++;
            }
        }
        return total;
    }
}