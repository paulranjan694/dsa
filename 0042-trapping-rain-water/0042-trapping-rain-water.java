class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightNearestMax = new int[n]; 
        int[] leftNearestMax = new int[n];
        int maxSoFar = -1;
        //leftNearestMax[0] = 0;
        for(int i=1;i<n;i++){
            maxSoFar = Math.max(height[i-1],maxSoFar);
            leftNearestMax[i] = maxSoFar;
        }

        maxSoFar = -1;
        for(int i=n-2;i>=0;i--){
             maxSoFar = Math.max(height[i+1],maxSoFar);
            rightNearestMax[i] = maxSoFar;
        }

        int maxWater=0;
        for(int i=1;i<n-1;i++){
            maxWater += Math.max(Math.min(leftNearestMax[i],rightNearestMax[i])-height[i],0);
        }
        return maxWater;
    }
}