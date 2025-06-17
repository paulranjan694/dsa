class Solution {
    public int maxArea(int[] height) {
        int maxAmount=0, n = height.length;
        int l=0,r=n-1;

        while(l<r){
            maxAmount = Math.max(maxAmount,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxAmount;
    }
}