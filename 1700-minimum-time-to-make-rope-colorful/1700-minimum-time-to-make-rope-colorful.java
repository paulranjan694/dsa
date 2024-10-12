class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;

        int left=0,right=0,minTime=0;
        while(left < n && right < n){
            int currMax=0,currTotal=0;
            while(right<n && colors.charAt(left)==colors.charAt(right)){
                currMax = Math.max(currMax,neededTime[right]);
                currTotal += neededTime[right];
                right++;
            }
            minTime += (currTotal - currMax);
            left=right;
        }
        return minTime;
    }
}